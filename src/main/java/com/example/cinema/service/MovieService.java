package com.example.cinema.service;

import com.example.cinema.dto.MovieRequestDTO;
import com.example.cinema.dto.MovieResponseDTO;
import java.util.List;

public interface MovieService {
    MovieResponseDTO createMovie(MovieRequestDTO dto);
    List<MovieResponseDTO> getAllMovies();
    MovieResponseDTO getMovieById(Long id);
    MovieResponseDTO updateMovie(Long id, MovieRequestDTO dto);
    void deleteMovie(Long id);
}