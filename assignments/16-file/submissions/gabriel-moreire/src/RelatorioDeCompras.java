import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDeCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: java RelatorioDeCompras <caminho_arquivo_entrada> <caminho_arquivo_saida>");
            System.err.println("Exemplo: java RelatorioDeCompras compras.txt report.txt");
            return;
        }

        Path arquivoEntrada = Paths.get(args[0]);
        Path arquivoSaida = Paths.get(args[1]);

        List<String> nomesClientes = new ArrayList<>();
        List<Double> totaisCompras = new ArrayList<>();

        System.out.println("Iniciando processamento do arquivo: " + arquivoEntrada);
        
        try {
            List<String> linhas = Files.readAllLines(arquivoEntrada, StandardCharsets.UTF_8);

            for (String linha : linhas) {
                String[] campos = linha.split(",");

                if (campos.length < 3) {
                    System.err.println("Aviso: Linha malformada ignorada: " + linha);
                    continue;
                }

                String nomeCliente = campos[0].trim();
                String valorStr = campos[2].trim();
                double valorCompra;

                try {
                    valorCompra = Double.parseDouble(valorStr);
                    acumularCompra(nomeCliente, valorCompra, nomesClientes, totaisCompras);

                } catch (NumberFormatException e) {
                    System.err.println("Aviso: Valor inválido (" + valorStr + ") na linha: " + linha + ". Compra ignorada.");
                }
            }
            
            gerarRelatorio(nomesClientes, totaisCompras, arquivoSaida);

        } catch (IOException e) {
            System.err.println("Erro de I/O ao processar o arquivo: " + e.getMessage());
        }
    }

    private static void acumularCompra(String nomeCliente, double valorCompra, 
                                       List<String> nomesClientes, List<Double> totaisCompras) {
        
        int indice = nomesClientes.indexOf(nomeCliente);

        if (indice != -1) {
            double totalAtual = totaisCompras.get(indice);
            totaisCompras.set(indice, totalAtual + valorCompra);
        } else {
            nomesClientes.add(nomeCliente);
            // CORREÇÃO: Adicionando o valor da compra inicial
            totaisCompras.add(valorCompra); 
        }
    }

    private static void gerarRelatorio(List<String> nomesClientes, List<Double> totaisCompras, Path arquivoSaida) throws IOException {
        
        List<String> linhasRelatorio = new ArrayList<>();
        
        for (int i = 0; i < nomesClientes.size(); i++) {
            String linha = String.format("%s: %.2f", nomesClientes.get(i), totaisCompras.get(i));
            linhasRelatorio.add(linha);
        }

        Files.write(arquivoSaida, linhasRelatorio, StandardCharsets.UTF_8);
        
        System.out.println("Processamento concluído com sucesso!");
        System.out.println("Relatório gerado em: " + arquivoSaida.toAbsolutePath());
    }
}