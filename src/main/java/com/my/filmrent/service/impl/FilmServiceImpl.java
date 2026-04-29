package com.my.filmrent.service.impl;

import com.my.filmrent.dto.AddFilmRequestDto;
import com.my.filmrent.dto.FilmResponseDto;
import com.my.filmrent.entity.*;
import com.my.filmrent.repository.*;
import com.my.filmrent.service.FilmService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final LanguageRepository languageRepository;
    private final ActorRepository actorRepository;
    private final CategoryRepository categoryRepository;
    private final StoreRepository storeRepository;
    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public FilmResponseDto addFilm(AddFilmRequestDto dto) {
        Language language = languageRepository.findById(dto.getLanguageId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Language not found: " + dto.getLanguageId()));

        Set<Actor> actors = actorRepository.findAllByActorIdIn(dto.getActorIds());
        Set<Category> categories = categoryRepository.findAllByCategoryIdIn(dto.getCategoryIds());

        Film film = new Film();
        film.setTitle(dto.getTitle());
        film.setDescription(dto.getDescription());
        film.setReleaseYear(dto.getReleaseYear());
        film.setLanguage(language);
        film.setRentalDuration(dto.getRentalDuration());
        film.setRentalRate(dto.getRentalRate());
        film.setLength(dto.getLength());
        film.setReplacementCost(dto.getReplacementCost());
        film.setRating(dto.getRating());
        film.setSpecialFeatures(dto.getSpecialFeatures());
        film.setActors(actors);
        film.setCategories(categories);

        // FilmText shares the PK with Film via @MapsId
        FilmText filmText = new FilmText();
        filmText.setTitle(dto.getFilmTextTitle());
        filmText.setDescription(dto.getFilmTextDescription());
        filmText.setFilm(film);
        film.setFilmText(filmText);

        filmRepository.save(film);

        // Create one inventory entry per requested store
        Set<Store> stores = dto.getStoreIds().stream()
                .map(storeId -> storeRepository.findById(storeId)
                        .orElseThrow(() -> new EntityNotFoundException(
                                "Store not found: " + storeId)))
                .collect(Collectors.toSet());

        for (Store store : stores) {
            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryRepository.save(inventory);
        }

        return toResponseDto(film);
    }

    private FilmResponseDto toResponseDto(Film film) {
        FilmResponseDto dto = new FilmResponseDto();
        dto.setFilmId(film.getFilmId());
        dto.setTitle(film.getTitle());
        dto.setDescription(film.getDescription());
        dto.setReleaseYear(film.getReleaseYear());
        dto.setRentalDuration(film.getRentalDuration());
        dto.setRentalRate(film.getRentalRate());
        dto.setLength(film.getLength());
        dto.setReplacementCost(film.getReplacementCost());
        dto.setRating(film.getRating());
        dto.setSpecialFeatures(film.getSpecialFeatures());
        dto.setLanguageId(film.getLanguage().getLanguageId());
        return dto;
    }
}
