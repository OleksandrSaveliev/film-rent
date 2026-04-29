package com.my.filmrent.service;

import com.my.filmrent.dto.AddFilmRequestDto;
import com.my.filmrent.dto.FilmResponseDto;

public interface FilmService {

    FilmResponseDto addFilm(AddFilmRequestDto requestDto);
}
