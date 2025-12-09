import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        
        if (args == null || args.length < 2) {
            System.err.println("Uso: java RelatorioCompras <caminhoEntrada/compras.txt> <caminhoSaida/report.txt>");
            System.exit(1);
        }

        Path entrada = Paths.get(args[0]);
        Path saida = Paths.get(args[1]);

       
        if (!entrada.getFileName().toString().equalsIgnoreCase("compras.txt")) {
            System.err.println("Aviso: o arquivo de entrada não se chama 'compras.txt'. Continuando...");
        }
        if (!saida.getFileName().toString().equalsIgnoreCase("report.txt")) {
            System.err.println("Aviso: o arquivo de saída não se chama 'report.txt'. Continuando...");
        }

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        List<String> linhas;
        try {
            linhas = Files.readAllLines(entrada, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
            return;
        }

        for (int linhaNum = 0; linhaNum < linhas.size(); linhaNum++) {
            String linha = linhas.get(linhaNum).trim();
            if (linha.isEmpty()) {
                continue; 
            }

           
            String[] partes = linha.split(",", -1);
            if (partes.length < 3) {
               
                System.err.println("Ignorando linha malformada (menos de 3 campos) na linha " + (linhaNum + 1) + ": " + linha);
                continue;
            }

            String nomeCliente = partes[0].trim();
           
            String valorStr = partes[2].trim();

            if (nomeCliente.isEmpty()) {
                System.err.println("Ignorando linha com nome de cliente vazio na linha " + (linhaNum + 1));
                continue;
            }

            double valor;
            try {
                valor = Double.parseDouble(valorStr);
            } catch (NumberFormatException nfe) {
                System.err.println("Ignorando linha com valor inválido na linha " + (linhaNum + 1) + ": '" + valorStr + "'");
                continue;
            }

            int idx = clientes.indexOf(nomeCliente);
            if (idx >= 0) {
                totais.set(idx, totais.get(idx) + valor);
            } else {
                clientes.add(nomeCliente);
                totais.add(valor);
            }
        }

        
        List<String> linhasSaida = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            String linha = String.format("%s: %.1f", clientes.get(i), totais.get(i));
            linhasSaida.add(linha);
        }

        try {
           
            Files.write(saida, linhasSaida, StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso em: " + saida.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo de saída: " + e.getMessage());
        }
    }
}

