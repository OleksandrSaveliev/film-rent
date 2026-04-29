package com.my.filmrent.repository;

import com.my.filmrent.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
