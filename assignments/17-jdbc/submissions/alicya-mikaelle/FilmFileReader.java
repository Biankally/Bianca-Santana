import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public List<Film> read(String path) {
        List<Film> films = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));

            for (String line : lines) {
                if (line.trim().isEmpty() || line.startsWith("title")) continue; 

                String[] parts = line.split(";");

                String title = parts[0];
                int languageId = Integer.parseInt(parts[1]);
                int rentalDuration = Integer.parseInt(parts[2]);
                double rentalRate = Double.parseDouble(parts[3]);
                double replacementCost = Double.parseDouble(parts[4]);

                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return films;
    }
}
