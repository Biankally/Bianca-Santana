import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        
        if (args.length < 2) {
            System.out.println("Erro: Caminhos dos arquivos de entrada e saída são necessários.");
            System.out.println("Uso: java RelatorioCompras <arquivoEntrada> <arquivoSaida>");
            System.out.println("Exemplo: java RelatorioCompras compras.txt report.txt");
            return;
        }

        Path inputPath = Paths.get(args[0]);
        Path outputPath = Paths.get(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        System.out.println("Processando arquivo: " + inputPath.toAbsolutePath());

        try {
            List<String> linhas = Files.readAllLines(inputPath);

            for (String linha : linhas) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] campos = linha.split(",");

                if (campos.length < 3) {
                    System.out.println("Linha malformada ignorada: " + linha);
                    continue;
                }

                try {
                    String nomeCliente = campos[0].trim();
                    double valor = Double.parseDouble(campos[2].trim());

                    int index = clientes.indexOf(nomeCliente);

                    if (index != -1) {
                        double totalAtual = totais.get(index);
                        totais.set(index, totalAtual + valor);
                    } else {
                        clientes.add(nomeCliente);
                        totais.add(valor);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Valor numérico inválido na linha (ignorada): " + linha);
                }
            }

        } catch (IOException e) {
            System.err.println("Erro fatal ao ler o arquivo de entrada: " + e.getMessage());
            return;
        }

        ArrayList<String> linhasSaida = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            String linhaRelatorio = String.format("%s: %.1f", clientes.get(i), totais.get(i));
            linhasSaida.add(linhaRelatorio);
        }

        try {
            Files.write(outputPath, linhasSaida);
            System.out.println("Relatório gerado com sucesso em: " + outputPath.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro fatal ao escrever o arquivo de saída: " + e.getMessage());
        }
    }
}