import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmReader{

    public List<Film> readFilms(String filePath){
        List<Film> films = new ArrayList<>();
        Path path = Paths.get(filePath);

        try {
            List<String> lines = Files.readAllLines(path);

            for (int i = 1; i < lines.size(); i++){
                String line = lines.get(i);
                if (line.trim().isEmpty()) continue;

                // Quebra a linha nos ponto-e-vírgula
                String[] parts = line.split(";");

                // Cria o objeto Filme 
                if (parts.length >= 5){
                    String title = parts[0].trim();
                    int langId = Integer.parseInt(parts[1].trim());
                    int duration = Integer.parseInt(parts[2].trim());
                    double rate = Double.parseDouble(parts[3].trim());
                    double replacement = Double.parseDouble(parts[4].trim());

                    films.add(new Film(title, langId, duration, rate, replacement));
                }
            }
        } catch (IOException e){
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (NumberFormatException e){
            System.err.println("Erro ao converter número: " + e.getMessage());
        }

        return films;
    }
}