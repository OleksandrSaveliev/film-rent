package com.my.filmrent.repository;

import com.my.filmrent.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
