import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmeLeitor {
    public static List<Filme> carregarFilmes(String caminhoArquivo) {
        List<Filme> lista = new ArrayList<>();
        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));
            for (int i = 1; i < linhas.size(); i++) {
                String[] partes = linhas.get(i).split(";");
                if (partes.length < 5) continue;
                try {
                    String titulo = partes[0].trim();
                    int idiomaId = Integer.parseInt(partes[1].trim());
                    int duracao = Integer.parseInt(partes[2].trim());
                    double taxa = Double.parseDouble(partes[3].trim());
                    double custo = Double.parseDouble(partes[4].trim());
                    lista.add(new Filme(titulo, idiomaId, duracao, taxa, custo));
                } catch (NumberFormatException ignored) {}
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return lista;
    }
}
