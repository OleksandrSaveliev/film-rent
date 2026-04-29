package com.my.filmrent.service.impl;

import com.my.filmrent.dto.RentInventoryRequestDto;
import com.my.filmrent.dto.RentalResponseDto;
import com.my.filmrent.dto.ReturnRentalRequestDto;
import com.my.filmrent.entity.*;
import com.my.filmrent.repository.*;
import com.my.filmrent.service.RentalService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final CustomerRepository customerRepository;
    private final InventoryRepository inventoryRepository;
    private final StaffRepository staffRepository;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public RentalResponseDto returnFilm(ReturnRentalRequestDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Customer not found: " + dto.getCustomerId()));

        Rental rental = rentalRepository.findById(dto.getRentalId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Rental not found: " + dto.getRentalId()));

        if (!rental.getCustomer().getCustomerId().equals(customer.getCustomerId())) {
            throw new IllegalArgumentException(
                    "Rental does not belong to customer: " + dto.getCustomerId());
        }

        if (rental.getReturnDate() != null) {
            throw new IllegalStateException(
                    "Film already returned for rental: " + dto.getRentalId());
        }

        rental.setReturnDate(LocalDateTime.now());
        rentalRepository.save(rental);

        return toResponseDto(rental);
    }

    @Override
    @Transactional
    public RentalResponseDto rentInventory(RentInventoryRequestDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Customer not found: " + dto.getCustomerId()));

        Inventory inventory = inventoryRepository.findById(dto.getInventoryId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Inventory not found: " + dto.getInventoryId()));

        Staff staff = staffRepository.findById(dto.getStaffId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Staff not found: " + dto.getStaffId()));

        Optional<Rental> latestRental =
                rentalRepository.findLatestByInventoryId(inventory.getInventoryId());

        if (latestRental.isPresent() && latestRental.get().getReturnDate() == null) {
            throw new IllegalStateException(
                    "Inventory is currently rented out: " + dto.getInventoryId());
        }

        Rental rental = new Rental();
        rental.setRentalDate(LocalDateTime.now());
        rental.setInventory(inventory);
        rental.setCustomer(customer);
        rental.setStaff(staff);
        rentalRepository.save(rental);

        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setStaff(staff);
        payment.setRental(rental);
        payment.setAmount(dto.getPaymentAmount());
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);

        return toResponseDto(rental);
    }

    private RentalResponseDto toResponseDto(Rental rental) {
        RentalResponseDto dto = new RentalResponseDto();
        dto.setRentalId(rental.getRentalId());
        dto.setCustomerId(rental.getCustomer().getCustomerId());
        dto.setInventoryId(rental.getInventory().getInventoryId());
        dto.setStaffId(rental.getStaff().getStaffId());
        dto.setRentalDate(rental.getRentalDate());
        dto.setReturnDate(rental.getReturnDate());
        return dto;
    }
}
