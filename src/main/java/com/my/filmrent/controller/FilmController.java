package com.my.filmrent.controller;

import com.my.filmrent.dto.AddFilmRequestDto;
import com.my.filmrent.dto.FilmResponseDto;
import com.my.filmrent.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    public ResponseEntity<FilmResponseDto> addFilm(
            @RequestBody AddFilmRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(filmService.addFilm(requestDto));
    }
}
