package com.jdbc17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmeLeitor {

    public List<Film> lerFilmes(String caminhoArquivo) {
        List<Film> filmes = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));

            for (String linha : linhas) {
                // Pula linhas vazias
                if (linha.trim().isEmpty()) continue;

                // CORREÇÃO CRÍTICA: Pula o cabeçalho se a linha começar com "title"
                if (linha.toLowerCase().startsWith("title")) continue;

                String[] dados = linha.split(";");

                // Verifica se a linha tem todas as colunas necessárias antes de tentar ler
                if (dados.length < 5) continue; 

                try {
                    String title = dados[0];
                    int languageId = Integer.parseInt(dados[1]);
                    int rentalDuration = Integer.parseInt(dados[2]);
                    double rentalRate = Double.parseDouble(dados[3]);
                    double replacementCost = Double.parseDouble(dados[4]);

                    Film filme = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
                    filmes.add(filme);
                } catch (NumberFormatException e) {
                    System.err.println("Ignorando linha com formato inválido: " + linha);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return filmes;
    }
}