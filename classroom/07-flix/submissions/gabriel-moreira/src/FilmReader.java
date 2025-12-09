import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilmReader {

    public static List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));

            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                String title = parts[0];
                int languageId = Integer.parseInt(parts[1]);
                int rentDuration = Integer.parseInt(parts[2]);
                double rentalRate = Double.parseDouble(parts[3]);
                double replacementCost = Double.parseDouble(parts[4]);

                films.add(new Film(title, languageId, rentDuration, rentalRate, replacementCost));
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return films;
    }
}
