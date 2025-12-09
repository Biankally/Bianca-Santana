
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class RelatorioClientes {

    public static void main(String[] args) {
        
        if (args.length < 2) {
            System.err.println("Erro: São necessários 2 argumentos: <arquivoDeEntrada> <arquivoDeSaida>");
            System.err.println("Exemplo: java RelatorioClientes compras.txt report.txt");
            return;
        }

        Path inputPath = Paths.get(args[0]);
        Path outputPath = Paths.get(args[1]);

        System.out.println("Processando arquivo de entrada: " + inputPath.toAbsolutePath());

        ArrayList<String> nomesClientes = new ArrayList<>();
        ArrayList<Double> totaisCompras = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(inputPath, StandardCharsets.UTF_8)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                
                String[] campos = linha.split(",");

                if (campos.length < 3) {
                    System.err.println("[Aviso] Linha malformada ignorada: " + linha);
                    continue; 
                }

                try {
                    String nome = campos[0].trim();
                    double valor = Double.parseDouble(campos[2].trim());

                    int index = nomesClientes.indexOf(nome);

                    if (index != -1) {
                        double totalAtual = totaisCompras.get(index);
                        totaisCompras.set(index, totalAtual + valor);
                    } else {
                        nomesClientes.add(nome);
                        totaisCompras.add(valor);
                    }

                } catch (NumberFormatException e) {
                    System.err.println("[Aviso] Valor numérico inválido na linha: " + linha);
                }
            } 

        } catch (IOException e) {
            System.err.println("Erro fatal ao ler o arquivo de entrada: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        System.out.println("Leitura concluída. Gerando relatório...");

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8)) {
            
            for (int i = 0; i < nomesClientes.size(); i++) {
                String nome = nomesClientes.get(i);
                Double total = totaisCompras.get(i);
                
                String linhaSaida = nome + ": " + total;
                
                writer.write(linhaSaida);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Erro fatal ao escrever o arquivo de saída: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Relatório gerado com sucesso em: " + outputPath.toAbsolutePath());
    }
}