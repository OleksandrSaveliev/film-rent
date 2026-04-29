package com.my.filmrent.repository;

import com.my.filmrent.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
