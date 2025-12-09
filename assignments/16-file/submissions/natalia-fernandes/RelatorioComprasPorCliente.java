import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioComprasPorCliente {

    public static void main(String[] args) {
        // Verifica se recebeu os dois argumentos: arquivo de entrada e arquivo de saída
        if (args.length < 2) {
            System.err.println("Uso: java RelatorioComprasPorCliente <arquivoEntrada> <arquivoSaida>");
            return;
        }

        // Caminhos de entrada e saída
        Path inputPath = Path.of(args[0]);   // Ex: compras.txt
        Path outputPath = Path.of(args[1]);  // Ex: report.txt

        // Listas paralelas: mesmo índice = mesmo cliente
        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            // Lê todas as linhas do arquivo de entrada
            List<String> linhas = Files.readAllLines(inputPath);

            for (String linha : linhas) {
                if (linha == null) continue;

                linha = linha.trim();
                if (linha.isEmpty()) continue;

                // Quebra a linha pelo separador vírgula
                String[] partes = linha.split(",");

                // Ignora linhas malformadas (menos de 3 campos)
                if (partes.length < 3) {
                    // Opcional: avisar
                    // System.err.println("Linha ignorada (malformada): " + linha);
                    continue;
                }

                String nomeCliente = partes[0].trim();
                // String nomeProduto = partes[1].trim(); // não é necessário para o relatório final
                String valorStr = partes[2].trim();

                double valorCompra;
                try {
                    valorCompra = Double.parseDouble(valorStr);
                } catch (NumberFormatException e) {
                    // Ignora linhas com valor inválido
                    // System.err.println("Linha ignorada (valor inválido): " + linha);
                    continue;
                }

                // Procura o cliente na lista
                int index = clientes.indexOf(nomeCliente);

                if (index == -1) {
                    // Novo cliente
                    clientes.add(nomeCliente);
                    totais.add(valorCompra);
                } else {
                    // Cliente já existe: acumula o valor
                    double totalAtual = totais.get(index);
                    totais.set(index, totalAtual + valorCompra);
                }
            }

            // Monta as linhas do relatório de saída
            ArrayList<String> saida = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                String linhaSaida = clientes.get(i) + ": " + totais.get(i);
                saida.add(linhaSaida);
            }

            // Grava no arquivo de saída (por exemplo, report.txt)
            Files.write(outputPath, saida);

            System.out.println("Relatório gerado com sucesso em: " + outputPath.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever arquivos: " + e.getMessage());
        }
    }
}
