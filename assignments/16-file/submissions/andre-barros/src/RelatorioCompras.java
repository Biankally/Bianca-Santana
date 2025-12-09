import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

public class RelatorioCompras {

    private static final String SEPARADOR = ",";

    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.err.println("Uso: java RelatorioCompras <caminho_arquivo_entrada> <caminho_arquivo_saida>");
            System.out.println("Exemplo: java RelatorioCompras compras.txt report.txt");
            return;
        }

        Path pathEntrada = Path.of(args[0]);
        Path pathSaida = Path.of(args[1]);

        List<String> nomesClientes = new ArrayList<>();
        List<Double> totaisCompras = new ArrayList<>();

        try {
            List<String> todasAsLinhas = Files.readAllLines(pathEntrada);
            System.out.println("Lendo " + todasAsLinhas.size() + " linhas do arquivo: " + pathEntrada);

            for (String linha : todasAsLinhas) {
                String[] campos = linha.trim().split(SEPARADOR);

                if (campos.length < 3) {
                    System.err.println("AVISO: Linha malformada ignorada: " + linha);
                    continue;
                }

                String nomeCliente = campos[0].trim();
                String valorStr = campos[2].trim();
                double valor;

                try {
                    valor = Double.parseDouble(valorStr);

                    int indice = nomesClientes.indexOf(nomeCliente);

                    if (indice == -1) {
                        nomesClientes.add(nomeCliente);
                        totaisCompras.add(valor);
                    } else {
                        double totalAtual = totaisCompras.get(indice);
                        totaisCompras.set(indice, totalAtual + valor);
                    }

                } catch (NumberFormatException e) {
                    System.err.println("ERRO DE CONVERSÃO: Valor inválido (" + valorStr + ") na linha: " + linha);
                }
            }

            List<String> linhasSaida = new ArrayList<>();
            for (int i = 0; i < nomesClientes.size(); i++) {
                String linhaRelatorio = String.format("%s: %.1f", nomesClientes.get(i), totaisCompras.get(i));
                linhasSaida.add(linhaRelatorio);
            }
            
            Files.write(pathSaida, linhasSaida, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            
            System.out.println("\nProcessamento concluído com sucesso!");
            System.out.println("Relatório consolidado gravado em: " + pathSaida);

        } catch (IOException e) {
            System.err.println("\nERRO CRÍTICO DE ARQUIVO: Não foi possível ler ou escrever o arquivo.");
            e.printStackTrace();
        }
    }
}