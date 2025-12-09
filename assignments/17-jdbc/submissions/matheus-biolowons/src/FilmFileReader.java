import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();
        Path path = Paths.get(filePath);

        try {
            List<String> lines = Files.readAllLines(path);
            boolean isFirstLine = true;

            for (String line : lines) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(";");

                if (parts.length >= 5) {
                    try {
                        String title = parts[0].trim();
                        int langId = Integer.parseInt(parts[1].trim());
                        int duration = Integer.parseInt(parts[2].trim());
                        double rate = Double.parseDouble(parts[3].trim());
                        double cost = Double.parseDouble(parts[4].trim());

                        films.add(new Film(title, langId, duration, rate, cost));
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter linha: " + line + " -> " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao processar arquivo: " + e.getMessage());
        }

        return films;
    }
}