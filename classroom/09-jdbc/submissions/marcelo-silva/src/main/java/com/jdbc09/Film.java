package com.jdbc09;

import java.time.LocalDateTime;

public class Film {
    private int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private LocalDateTime lastUpdate;

    // Construtor para INSERÇÃO
    public Film(String title, String description, int releaseYear) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    // Construtor completo (usado na BUSCA/READ)
    public Film(int filmId, String title, String description, int releaseYear, LocalDateTime lastUpdate) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.lastUpdate = lastUpdate;
    }

    // Getters e Setters (Encapsulamento)
    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
    public LocalDateTime getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(LocalDateTime lastUpdate) { this.lastUpdate = lastUpdate; }

    @Override
    public String toString() {
        return "Film [ID=" + filmId + ", Título=" + title + ", Ano=" + releaseYear + "]";
    }
}