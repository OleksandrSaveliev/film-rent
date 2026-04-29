package com.my.filmrent.controller;

import com.my.filmrent.dto.request.AddFilmRequestDto;
import com.my.filmrent.dto.response.FilmResponseDto;
import com.my.filmrent.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
