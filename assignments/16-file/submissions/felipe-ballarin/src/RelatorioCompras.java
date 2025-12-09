import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {

        // Verifica os2 argumentos
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompras <entrada> <saida>");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            
            List<String> linhas = Files.readAllLines(inputPath);

            for (String linha : linhas) {

                // Divide pelas virgulas
                String[] partes = linha.split(",");

                // Ignora linhas com menos de 3 campos
                if (partes.length < 3) {
                    System.out.println("Linha ignorada (malformada): " + linha);
                    continue;
                }

                String nomeCliente = partes[0].trim();
                String nomeProduto = partes[1].trim();
                String valorStr = partes[2].trim();

                double valor;

                // try p converter o valor p double
                try {
                    valor = Double.parseDouble(valorStr);
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido na linha: " + linha);
                    continue; 
                }

                // Procura o cliente na lista 
                int index = -1;
                for (int i = 0; i < clientes.size(); i++) {
                    if (clientes.get(i).equals(nomeCliente)) {
                        index = i;
                        break;
                    }
                }

                // Se o cliente n existe
                if (index == -1) {
                    clientes.add(nomeCliente);
                    totais.add(valor);
                } else {
                    // Se jah existe, acumula
                    totais.set(index, totais.get(index) + valor);
                }
            }

            // Monta o arraylist de saida
            ArrayList<String> saida = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                saida.add(clientes.get(i) + ": " + totais.get(i));
            }

            // Grava em report.txt
            Files.write(outputPath, saida);

            System.out.println("Relatório gerado com sucesso em: " + outputPath);

        } catch (Exception e) {
            System.out.println("Erro ao processar arquivo: " + e.getMessage());
        }
    }
}

