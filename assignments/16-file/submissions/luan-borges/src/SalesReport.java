import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class SalesReport {

    public static void main(String[] args) {
        System.out.println("=== Processamento de Relatório de Vendas ===");

        String inputPathStr = (args.length >= 1) ? args[0] : "data/compras.txt";
        String outputPathStr = (args.length >= 2) ? args[1] : "data/report.txt";

        Path inputFile = Paths.get(inputPathStr);
        Path outputFile = Paths.get(outputPathStr);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            if (!Files.exists(inputFile)) {
                System.out.println("Erro: Arquivo de entrada não encontrado em: " + inputFile.toAbsolutePath());
                return;
            }

            List<String> linhas = Files.readAllLines(inputFile);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    System.out.println("Linha ignorada (formato inválido): " + linha);
                    continue;
                }

                String nome = partes[0].trim();
                String valorStr = partes[2].trim();

                try {
                    double valor = Double.parseDouble(valorStr);

                    int indice = -1;

                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).equals(nome)) {
                            indice = i;
                            break;
                        }
                    }

                    if (indice != -1) {
                        double totalAtual = totais.get(indice);
                        totais.set(indice, totalAtual + valor);
                    } else {
                        clientes.add(nome);
                        totais.add(valor);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter valor na linha: " + linha + " - " + e.getMessage());
                }
            }

            List<String> linhasSaida = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                String linhaFormatada = clientes.get(i) + ": " + totais.get(i);
                linhasSaida.add(linhaFormatada);
            }

            Files.write(outputFile, linhasSaida, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso em: " + outputFile.toAbsolutePath());

            System.out.println("\n--- Conteúdo do Relatório ---");
            linhasSaida.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Erro de E/S ao manipular arquivos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
