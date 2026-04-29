package com.my.filmrent.repository;

import com.my.filmrent.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
