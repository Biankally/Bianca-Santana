import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmReader {

    public List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();
        
        try {

            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            // Começa do 1 para pular o cabeçalho
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.trim().isEmpty()) continue;

                // Quebra a linha no ponto virgula
                String[] data = line.split(";");
                
                // Extrai os dados (title;language_id;rent_duration;rental_rate;replacement_cost)
                String title = data[0];
                int languageId = Integer.parseInt(data[1]);
                int rentalDuration = Integer.parseInt(data[2]);
                double rentalRate = Double.parseDouble(data[3]);
                double replacementCost = Double.parseDouble(data[4]);

                Film film = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
                films.add(film);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro de formato no arquivo (numero invalido): " + e.getMessage());
        }
        
        return films;
    }
}