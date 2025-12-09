import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public List<Film> readFilmsFromFile(String filePath) {
        List<Film> films = new ArrayList<>();

        Path path = Paths.get(filePath);

        try {
            List<String> lines = Files.readAllLines(path);

            boolean isFirstLine = true;
            for (String line : lines) {
                if (line == null) {
                    continue;
                }

                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // primeira linha é o cabeçalho:
                // title;language_id;rent_duration;rental_rate;replacement_cost
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length < 5) {
                    // linha malformada, ignora
                    continue;
                }

                String title = parts[0].trim();
                int languageId;
                int rentalDuration;
                double rentalRate;
                double replacementCost;

                try {
                    languageId = Integer.parseInt(parts[1].trim());
                    rentalDuration = Integer.parseInt(parts[2].trim());
                    rentalRate = Double.parseDouble(parts[3].trim());
                    replacementCost = Double.parseDouble(parts[4].trim());
                } catch (NumberFormatException e) {
                    // se der erro na conversão, ignora a linha
                    continue;
                }

                Film film = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
                films.add(film);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo de filmes: " + e.getMessage());
        }

        return films;
    }
}
