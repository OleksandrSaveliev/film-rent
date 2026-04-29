package com.my.filmrent.repository;

import com.my.filmrent.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    @Query("SELECT r FROM Rental r WHERE r.inventory.inventoryId = :inventoryId " +
           "ORDER BY r.rentalDate DESC LIMIT 1")
    Optional<Rental> findLatestByInventoryId(@Param("inventoryId") Integer inventoryId);
}
