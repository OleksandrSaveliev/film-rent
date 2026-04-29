package com.my.filmrent.repository;

import com.my.filmrent.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Set<Category> findAllByCategoryIdIn(Set<Integer> categoryIds);
}
