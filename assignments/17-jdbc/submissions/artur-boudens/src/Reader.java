import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<Film> lerFilmes(String caminhoArquivo) {
        List<Film> filmes = new ArrayList<>();
        Path path = Paths.get(caminhoArquivo);

        try {
            List<String> linhas = Files.readAllLines(path);

            for (String linha : linhas) {
                if (linha.trim().isEmpty() || linha.startsWith("title")) continue;

                String[] dados = linha.split(";");

                String title = dados[0];
                int languageId = Integer.parseInt(dados[1]);
                int rentalDuration = Integer.parseInt(dados[2]);
                double rentalRate = Double.parseDouble(dados[3]);
                double replacementCost = Double.parseDouble(dados[4]);

                Film filme = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
                filmes.add(filme);
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        return filmes;
    }
}