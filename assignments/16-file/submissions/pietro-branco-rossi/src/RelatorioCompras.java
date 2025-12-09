import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras{

    public static void main (String[] args){

        String caminhoEntrada = (args.length > 0) ? args[0] : "compras.txt";
        String caminhoSaida = (args.length > 1) ? args[1] : "report.txt";

        Path pathEntrada = Paths.get(caminhoEntrada);
        Path pathSaida = Paths.get(caminhoSaida);

        ArrayList<String> nomesClientes = new ArrayList<>();
        ArrayList<Double> totaisCompras = new ArrayList<>();

        System.out.println("Lendo arquivo: " + pathEntrada.toAbsolutePath());

        try {
            List<String> linhas = Files.readAllLines(pathEntrada);

            for (String linha : linhas){
                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(",");

                // Ignora linhas com menos de 3 campos
                if (partes.length < 3){
                    System.err.println("Linha ignorada (formato inválido): " + linha);
                    continue;
                }

                String nomeCliente = partes[0].trim();
                // O produto (partes[1]) não é usado para a soma, mas existe na linha
                String valorStr = partes[2].trim();

                try {
                    double valor = Double.parseDouble(valorStr);

                    int index = nomesClientes.indexOf(nomeCliente);

                    if (index != -1) {
                        // Cliente já existe, atualiza o total na outra lista
                        double valorAtual = totaisCompras.get(index);
                        totaisCompras.set(index, valorAtual + valor);
                    } else {
                        // Se não, adiciona nas duas listas
                        nomesClientes.add(nomeCliente);
                        totaisCompras.add(valor);
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter valor numérico na linha: " + linha);
                }
            }

            ArrayList<String> linhasSaida = new ArrayList<>();
            for (int i = 0; i < nomesClientes.size(); i++){
                String linhaRelatorio = nomesClientes.get(i) + ": " + totaisCompras.get(i);
                linhasSaida.add(linhaRelatorio);
            }

            // Gravando o arquivo de saída
            Files.write(pathSaida, linhasSaida, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso em: " + pathSaida.toAbsolutePath());

        } catch (IOException e){
            System.err.println("Erro de I/O ao manipular arquivos: " + e.getMessage());
        }
    }
}