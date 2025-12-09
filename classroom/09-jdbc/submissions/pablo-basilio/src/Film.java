package com.idpflix.model;

import java.time.LocalDate;

public class Film {
    private int filmId;
    private String title;
    private int languageId;
    private int rentalDuration;
    private double rentalRate;
    private double replacementCost;
    private LocalDate releaseYear; 


    public Film(int filmId, String title, int languageId, int rentalDuration, double rentalRate, double replacementCost, LocalDate releaseYear) {
        this.filmId = filmId;
        this.title = title;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.releaseYear = releaseYear;
    }

    public Film(String title, int languageId, int rentalDuration, double rentalRate, double replacementCost, LocalDate releaseYear) {
        this.title = title;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.releaseYear = releaseYear;
    }

    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getLanguageId() { return languageId; }
    public void setLanguageId(int languageId) { this.languageId = languageId; }
    public int getRentalDuration() { return rentalDuration; }
    public void setRentalDuration(int rentalDuration) { this.rentalDuration = rentalDuration; }
    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }
    public double getReplacementCost() { return replacementCost; }
    public void setReplacementCost(double replacementCost) { this.replacementCost = replacementCost; }
    public LocalDate getReleaseYear() { return releaseYear; }
    public void setReleaseYear(LocalDate releaseYear) { this.releaseYear = releaseYear; }

    @Override
    public String toString() {
        return "Film [ID=" + filmId + ", Título='" + title + "', Locação=" + rentalDuration + " dias, Taxa=$" + rentalRate + "]";
    }
}