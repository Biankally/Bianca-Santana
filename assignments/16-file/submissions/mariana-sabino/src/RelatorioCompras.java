import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

class ArquivoUtils {
    public static List<String> lerArquivo(String caminho) throws IOException {
        Path path = Paths.get(caminho);
        return Files.readAllLines(path);
    }

    public static void escreverArquivo(String caminho, List<String> linhas) throws IOException {
        Path path = Paths.get(caminho);
        Files.write(path, linhas,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE);
    }
}

public class RelatorioCompras {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java RelatorioCompras <arquivoEntrada> <arquivoSaida>");
            System.exit(1);
        }

        String caminhoEntrada = args[0];
        String caminhoSaida = args[1];

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = ArquivoUtils.lerArquivo(caminhoEntrada);

            for (String linha : linhas) {
                if (linha.trim().isEmpty()) continue; 

                String[] partes = linha.split(",");

                if (partes.length < 3) continue;

                String nome = partes[0].trim();
                String valorStr = partes[2].trim();

                try {
                    double valor = Double.parseDouble(valorStr);

                    int index = clientes.indexOf(nome);
                    if (index >= 0) {
                        totais.set(index, totais.get(index) + valor);
                    } else {
                        clientes.add(nome);
                        totais.add(valor);
                    }
                } catch (NumberFormatException e) {
                   
                    continue;
                }
            }

            List<String> relatorio = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                relatorio.add(clientes.get(i) + ": " + totais.get(i));
            }

            ArquivoUtils.escreverArquivo(caminhoSaida, relatorio);
            System.out.println("Relatório gerado com sucesso em: " + caminhoSaida);

        } catch (IOException e) {
            System.err.println("Erro ao acessar arquivos: " + e.getMessage());
            System.exit(1);
        }
    }
}
