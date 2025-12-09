package model;

public class Film {
    private int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private int languageId;

    public Film() {}

    public Film(String title, String description, int releaseYear, int languageId) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
    }

    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getReleaseYear() { return releaseYear; }
    public int getLanguageId() { return languageId; }
    
    @Override
    public String toString() {
        return "Filme [ID=" + filmId + ", Titulo=" + title + ", Ano=" + releaseYear + "]";
    }
}