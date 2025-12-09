package com.idpflix.util;

import com.idpflix.model.Film;
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
            // Usa Files.readAllLines() para ler todas as linhas do arquivo
            List<String> lines = Files.readAllLines(path);
            
            // Ignora a primeira linha (cabeçalho) se houver
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(";");

                if (parts.length == 5) {
                    try {
                        String title = parts[0].trim();
                        int languageId = Integer.parseInt(parts[1].trim());
                        int rentalDuration = Integer.parseInt(parts[2].trim());
                        double rentalRate = Double.parseDouble(parts[3].trim());
                        double replacementCost = Double.parseDouble(parts[4].trim());

                        films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter números na linha: " + line + ". Pulando.");
                    }
                } else {
                    System.err.println("Formato de linha inválido: " + line + ". Pulando.");
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + filePath + ": " + e.getMessage());
            e.printStackTrace();
        }

        return films;
    }
}