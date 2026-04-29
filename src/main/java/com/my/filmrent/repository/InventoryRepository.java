package com.my.filmrent.repository;

import com.my.filmrent.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
