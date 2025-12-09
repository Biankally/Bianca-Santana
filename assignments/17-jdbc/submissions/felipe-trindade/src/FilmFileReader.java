import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public List<Film> read(Path path) {
        List<Film> films = new ArrayList<>();
        List<String> lines;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
            return films;
        }

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(";");
            if (parts.length != 5) {
                continue;
            }

            String title = parts[0].trim();
            int languageId = Integer.parseInt(parts[1].trim());
            int rentalDuration = Integer.parseInt(parts[2].trim());
            double rentalRate = Double.parseDouble(parts[3].trim());
            double replacementCost = Double.parseDouble(parts[4].trim());

            films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
        }

        return films;
    }
}