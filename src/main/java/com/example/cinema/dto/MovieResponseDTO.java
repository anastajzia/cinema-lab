package com.example.cinema.dto;

public class MovieResponseDTO {
    private Long id;
    private String title;
    private Integer duration;
    private Integer releaseYear;
    private DirectorDTO director;
    private String genreName;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }
    public DirectorDTO getDirector() { return director; }
    public void setDirector(DirectorDTO director) { this.director = director; }
    public String getGenreName() { return genreName; }
    public void setGenreName(String genreName) { this.genreName = genreName; }
}