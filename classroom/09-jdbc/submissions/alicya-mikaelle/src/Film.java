package model;

public class Film {

    private int filmId;
    private String title;
    private String description;
    private int languageId;

    public Film() {}

    public Film(String title, String description, int languageId) {
        this.title = title;
        this.description = description;
        this.languageId = languageId;
    }

    public Film(int filmId, String title, String description, int languageId) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.languageId = languageId;
    }

    public int getFilmId() { return filmId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getLanguageId() { return languageId; }

    public void setFilmId(int filmId) { this.filmId = filmId; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setLanguageId(int languageId) { this.languageId = languageId; }
}
