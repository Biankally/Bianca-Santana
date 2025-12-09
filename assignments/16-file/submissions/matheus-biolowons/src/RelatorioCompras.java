import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {
    public static void main(String[] args) {
        Path inputPath = Paths.get("../../data/compras.txt");
        Path outputPath = Paths.get("report.txt");

        ArrayList<String> clientNames = new ArrayList<>();
        ArrayList<Double> clientTotals = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(inputPath);

            for (String line : lines) {
                String[] parts = line.split(",");

                // Validação: Ignora linhas malformadas (menos de 3 campos)
                if (parts.length < 3) {
                    System.err.println("Linha ignorada (formato inválido): " + line);
                    continue;
                }

                String client = parts[0].trim();

                double value = 0.0;
                try {
                    value = Double.parseDouble(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter valor na linha: " + line);
                    continue;
                }

                // Verifica se o cliente já existe na lista de nomes
                int index = clientNames.indexOf(client);

                if (index != -1) {
                    // Cliente JÁ existe: atualiza o total na lista paralela usando o mesmo índice
                    double currentTotal = clientTotals.get(index);
                    clientTotals.set(index, currentTotal + value);
                } else {
                    // Cliente NÃO existe: adiciona nas duas listas
                    clientNames.add(client);
                    clientTotals.add(value);
                }
            }

            // Escrita do relatório
            List<String> outputLines = new ArrayList<>();
            for (int i = 0; i < clientNames.size(); i++) {
                String name = clientNames.get(i);
                Double total = clientTotals.get(i);
                outputLines.add(name + ": " + total);
            }

            Files.write(outputPath, outputLines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Relatório gerado com sucesso em: " + outputPath.toAbsolutePath());
            System.out.println("-------------------------------------------------");
            outputLines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Erro de E/S ao manipular arquivos: " + e.getMessage());
        }
    }
}