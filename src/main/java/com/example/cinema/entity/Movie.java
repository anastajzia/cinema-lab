package com.example.cinema.entity;

import jakarta.persistence.*;
import java.time.Year;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private Year releaseYear;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    public Movie() {}

    public Movie(String title, Integer duration, Year releaseYear, Director director, Genre genre) {
        this.title = title;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.director = director;
        this.genre = genre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public Year getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Year releaseYear) { this.releaseYear = releaseYear; }
    public Director getDirector() { return director; }
    public void setDirector(Director director) { this.director = director; }
    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }
}