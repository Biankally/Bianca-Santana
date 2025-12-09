package util;

import model.Film;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public static List<Film> readFilmsFromFile(String filePath) {
        List<Film> films = new ArrayList<>();
        Path path = Paths.get(filePath); 

        try {
            List<String> lines = Files.readAllLines(path);

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(";");

                if (parts.length == 5) {
                    try {
                        String title = parts[0];
                        int languageId = Integer.parseInt(parts[1].trim());
                        int rentalDuration = Integer.parseInt(parts[2].trim());
                        double rentalRate = Double.parseDouble(parts[3].trim().replace(",", ".")); 
                        double replacementCost = Double.parseDouble(parts[4].trim().replace(",", "."));

                        films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));

                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter número na linha: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + filePath + ". Verifique o caminho. Erro: " + e.getMessage());
        }
        return films;
    }
}