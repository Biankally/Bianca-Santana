import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {

    public static void main(String[] args) {
        String arquivoEntrada = "../../data/compras.txt";
        String arquivoSaida = "relatorio.txt";

        if (args.length >= 1) {
            arquivoEntrada = args[0];
        }
        if (args.length >= 2) {
            arquivoSaida = args[1];
        }

        Path pathEntrada = Paths.get(arquivoEntrada);
        Path pathSaida = Paths.get(arquivoSaida);

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        List<String> linhas;
        try {
            linhas = Files.readAllLines(pathEntrada, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo de entrada: " + e.getMessage());
            return;
        }

        for (String linha : linhas) {
            if (linha == null) continue;
            linha = linha.trim();
            if (linha.isEmpty()) continue;

            String[] partes = linha.split(",");
            if (partes.length < 3) {
                continue;
            }

            String nome = partes[0].trim();
            String valorStr = partes[2].trim();

            double valor;
            try {
                valor = Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                System.err.println("Valor inválido: " + valorStr);
                continue;
            }

            int idx = -1;
            for (int i = 0; i < nomes.size(); i++) {
                if (nomes.get(i).equals(nome)) {
                    idx = i;
                    break;
                }
            }

            if (idx == -1) {
                nomes.add(nome);
                totais.add(valor);
            } else {
                totais.set(idx, totais.get(idx) + valor);
            }
        }

        ArrayList<String> saida = new ArrayList<>();
        for (int i = 0; i < nomes.size(); i++) {
            saida.add(nomes.get(i) + ": " + totais.get(i));
        }

        try {
            Files.write(pathSaida, saida, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo de saída: " + e.getMessage());
        }
    }
}