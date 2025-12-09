public class Film {
    private Integer filmId;
    private String title;
    private String description;
    private int languageId;

    public Film(String title, String description, int languageId) {
        this.title = title;
        this.description = description;
        this.languageId = languageId;
    }

    public Film(Integer filmId, String title, String description, int languageId) {
        this(title, description, languageId);
        this.filmId = filmId;
    }

    public Integer getFilmId() { return filmId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getLanguageId() { return languageId; }

    @Override
    public String toString() {
        return String.format("Filme [ID=%d, Titulo=%s]", filmId, title);
    }
}