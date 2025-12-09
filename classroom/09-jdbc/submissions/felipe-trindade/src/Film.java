public class Film {

    private int id;
    private String title;
    private String description;
    private Integer releaseYear;

    public Film() { }

    public Film(int id, String title, String description, Integer releaseYear) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    public Film(String title, String description, Integer releaseYear) {
        this(0, title, description, releaseYear);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Film{id=" + id +
                ", title='" + title + '\'' +
                ", year=" + releaseYear +
                ", desc='" + description + '\'' +
                '}';
    }
}
