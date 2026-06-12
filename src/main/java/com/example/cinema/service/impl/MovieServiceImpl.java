package com.example.cinema.service.impl;

import com.example.cinema.dto.*;
import com.example.cinema.entity.*;
import com.example.cinema.exception.*;
import com.example.cinema.repository.*;
import com.example.cinema.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository,
                            DirectorRepository directorRepository,
                            GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    @Transactional
    public MovieResponseDTO createMovie(MovieRequestDTO dto) {
        if (movieRepository.existsByTitle(dto.getTitle())) {
            throw new DuplicateResourceException("Movie with title '" + dto.getTitle() + "' already exists");
        }

        Director director = directorRepository.findById(dto.getDirectorId())
                .orElseThrow(() -> new ResourceNotFoundException("Director not found with id: " + dto.getDirectorId()));

        Genre genre = genreRepository.findById(dto.getGenreId())
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + dto.getGenreId()));

        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDuration(dto.getDuration());
        movie.setReleaseYear(Year.of(dto.getReleaseYear()));
        movie.setDirector(director);
        movie.setGenre(genre);

        Movie saved = movieRepository.save(movie);
        return toResponseDTO(saved);
    }

    @Override
    public List<MovieResponseDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponseDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        return toResponseDTO(movie);
    }

    @Override
    @Transactional
    public MovieResponseDTO updateMovie(Long id, MovieRequestDTO dto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        if (!movie.getTitle().equals(dto.getTitle()) && movieRepository.existsByTitle(dto.getTitle())) {
            throw new DuplicateResourceException("Movie with title '" + dto.getTitle() + "' already exists");
        }

        Director director = directorRepository.findById(dto.getDirectorId())
                .orElseThrow(() -> new ResourceNotFoundException("Director not found with id: " + dto.getDirectorId()));

        Genre genre = genreRepository.findById(dto.getGenreId())
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + dto.getGenreId()));

        movie.setTitle(dto.getTitle());
        movie.setDuration(dto.getDuration());
        movie.setReleaseYear(Year.of(dto.getReleaseYear()));
        movie.setDirector(director);
        movie.setGenre(genre);

        Movie updated = movieRepository.save(movie);
        return toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found with id: " + id);
        }
        movieRepository.deleteById(id);
    }

    private MovieResponseDTO toResponseDTO(Movie movie) {
        MovieResponseDTO dto = new MovieResponseDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDuration(movie.getDuration());
        dto.setReleaseYear(movie.getReleaseYear().getValue());

        DirectorDTO directorDTO = new DirectorDTO();
        directorDTO.setId(movie.getDirector().getId());
        directorDTO.setName(movie.getDirector().getName());
        dto.setDirector(directorDTO);

        dto.setGenreName(movie.getGenre().getName());
        return dto;
    }
}