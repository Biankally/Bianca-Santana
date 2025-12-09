package dvdrental;

public class Film {

    private int id;
    private String title;
    private String description;
    private int releaseYear;
    private int lengthMinutes;

    public Film() {
    }

    public Film(String title, String description, int releaseYear, int lengthMinutes) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.lengthMinutes = lengthMinutes;
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public void setLengthMinutes(int lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", lengthMinutes=" + lengthMinutes +
                '}';
    }
}
