import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmReader {

    public static List<Film> readFilms(String filePath) {
        ArrayList<Film> films = new ArrayList<>();

        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] fields = line.split(";");

                if (fields.length < 5) {
                    continue;
                }

                try {
                    String title = fields[0].trim();
                    int languageId = Integer.parseInt(fields[1].trim());
                    int rentalDuration = Integer.parseInt(fields[2].trim());
                    double rentalRate = Double.parseDouble(fields[3].trim());
                    double replacementCost = Double.parseDouble(fields[4].trim());

                    Film film = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
                    films.add(film);
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        } catch (java.io.IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return films;
    }
}