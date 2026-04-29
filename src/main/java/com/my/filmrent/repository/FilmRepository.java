package com.my.filmrent.repository;

import com.my.filmrent.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
