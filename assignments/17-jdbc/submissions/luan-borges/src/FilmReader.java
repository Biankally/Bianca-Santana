import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmReader {

    public List<Film> readFilms(String caminhoDoArquivo) {
        List<Film> listaFilmes = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoDoArquivo));

            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);
                String[] partes = linha.split(";");

                String title = partes[0];
                int languageId = Integer.parseInt(partes[1]);
                int duration = Integer.parseInt(partes[2]);
                double rate = Double.parseDouble(partes[3]);
                double cost = Double.parseDouble(partes[4]);

                listaFilmes.add(new Film(title, languageId, duration, rate, cost));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return listaFilmes;
    }
}
