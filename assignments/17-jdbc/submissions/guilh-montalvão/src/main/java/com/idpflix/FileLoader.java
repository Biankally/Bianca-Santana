package com.idpflix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<Film> loadFilms(String filePath) {
        List<Film> films = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            // Pular cabeçalho se existir (assumindo que a primeira linha pode ser cabeçalho se começar com 'title')
            boolean isFirstLine = true;
            
            for (String line : lines) {
                if (isFirstLine && line.startsWith("title")) {
                    isFirstLine = false;
                    continue;
                }
                
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String title = parts[0];
                    int languageId = Integer.parseInt(parts[1]);
                    int rentalDuration = Integer.parseInt(parts[2]);
                    double rentalRate = Double.parseDouble(parts[3]);
                    double replacementCost = Double.parseDouble(parts[4]);

                    films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter dados do arquivo: " + e.getMessage());
        }
        return films;
    }
}
