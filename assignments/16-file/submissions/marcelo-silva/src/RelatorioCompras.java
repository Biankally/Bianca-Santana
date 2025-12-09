import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: java RelatorioCompras <caminho_arquivo_entrada> <caminho_arquivo_saida>");
            return;
        }

        String arquivoEntradaStr = args[0];
        String arquivoSaidaStr = args[1];

        Path caminhoEntrada = Paths.get(arquivoEntradaStr);
        Path caminhoSaida = Paths.get(arquivoSaidaStr);

        List<String> clientes = new ArrayList<>();
        List<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(caminhoEntrada);

            for (String linha : linhas) {
                linha = linha.trim();
                if (linha.isEmpty()) {
                    continue;
                }

                String[] campos = linha.split(",");

                if (campos.length < 3) {
                    continue;
                }

                String nomeCliente = campos[0].trim();
                String valorStr = campos[2].trim();
                double valorCompra;

                try {
                    valorCompra = Double.parseDouble(valorStr);

                    int indiceCliente = clientes.indexOf(nomeCliente);

                    if (indiceCliente == -1) {
                        clientes.add(nomeCliente);
                        totais.add(valorCompra);
                    } else {
                        double totalAtual = totais.get(indiceCliente);
                        totais.set(indiceCliente, totalAtual + valorCompra);
                    }

                } catch (NumberFormatException e) {
                    continue;
                }
            }
            
            List<String> relatorio = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                String linhaRelatorio = clientes.get(i) + ": " + String.format("%.2f", totais.get(i));
                relatorio.add(linhaRelatorio);
            }

            Files.write(caminhoSaida, relatorio);

            System.out.println("Relatório gerado com sucesso em: " + arquivoSaidaStr);

        } catch (IOException e) {
            System.err.println("ERRO de I/O ao processar o arquivo.");
            System.err.println("Detalhe: " + e.getMessage());
        } catch (Exception e) {
             System.err.println("ERRO inesperado: " + e.getMessage());
        }
    }
}