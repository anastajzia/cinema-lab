package com.example.cinema.dto;

import jakarta.validation.constraints.*;

public class MovieRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer duration;

    @NotNull(message = "Release year is required")
    @Min(value = 1888, message = "Year must be >= 1888")
    @Max(value = 2030, message = "Year must be <= 2030")
    private Integer releaseYear;

    @NotNull(message = "Director ID is required")
    private Long directorId;

    @NotNull(message = "Genre ID is required")
    private Long genreId;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
    public Long getDirectorId() { return directorId; }
    public void setDirectorId(Long directorId) { this.directorId = directorId; }
    public Long getGenreId() { return genreId; }
    public void setGenreId(Long genreId) { this.genreId = genreId; }
}