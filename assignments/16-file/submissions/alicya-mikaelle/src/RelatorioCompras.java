import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompras <arquivoEntrada> <arquivoSaida>");
            return;
        }

        Path caminhoEntrada = Paths.get(args[0]);
        Path caminhoSaida = Paths.get(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(caminhoEntrada);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                // Ignorar linhas malformadas
                if (partes.length < 3) {
                    System.out.println("Linha ignorada (formato inválido): " + linha);
                    continue;
                }

                String nomeCliente = partes[0].trim();
                String nomeProduto = partes[1].trim();
                String valorStr = partes[2].trim();

                double valor;
                try {
                    valor = Double.parseDouble(valorStr);
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido em linha: " + linha);
                    continue;
                }

                // Verifica se o cliente já está na lista
                int indice = clientes.indexOf(nomeCliente);
                if (indice == -1) {
                    clientes.add(nomeCliente);
                    totais.add(valor);
                } else {
                    totais.set(indice, totais.get(indice) + valor);
                }
            }

            // Gerar linhas de saída
            ArrayList<String> saida = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                saida.add(clientes.get(i) + ": " + totais.get(i));
            }

            // Gravar o arquivo de saída
            Files.write(caminhoSaida, saida);
            System.out.println("Relatório gerado com sucesso em: " + caminhoSaida);

        } catch (IOException e) {
            System.out.println("Erro ao ler ou escrever arquivo: " + e.getMessage());
        }
    }
}
