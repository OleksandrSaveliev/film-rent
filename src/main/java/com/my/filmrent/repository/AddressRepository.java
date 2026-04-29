package com.my.filmrent.repository;

import com.my.filmrent.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
