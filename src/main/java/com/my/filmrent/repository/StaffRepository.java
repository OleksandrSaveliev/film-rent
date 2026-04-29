package com.my.filmrent.repository;

import com.my.filmrent.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
