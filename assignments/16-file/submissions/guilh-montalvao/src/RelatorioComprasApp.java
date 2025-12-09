import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioComprasApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioComprasApp <inputPath> <outputPath>");
            return;
        }

        Path inputPath = Paths.get(args[0]);
        Path outputPath = Paths.get(args[1]);

        ArrayList<String> customers = new ArrayList<>();
        ArrayList<Double> totals = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line == null) continue;
                String trimmed = line.trim();
                trimmed = trimmed.replace("\uFEFF", "");
                if (trimmed.isEmpty()) continue;
                String[] parts = trimmed.split(",");
                if (parts.length < 3) continue;
                String customer = parts[0].trim();
                String valueStr = parts[2].trim();
                double value;
                try {
                    value = Double.parseDouble(valueStr);
                } catch (NumberFormatException e) {
                    continue;
                }

                int idx = customers.indexOf(customer);
                if (idx >= 0) {
                    totals.set(idx, totals.get(idx) + value);
                } else {
                    customers.add(customer);
                    totals.add(value);
                }
            }

            ArrayList<String> report = new ArrayList<>();
            for (int i = 0; i < customers.size(); i++) {
                report.add(customers.get(i) + ": " + totals.get(i));
            }

            Files.write(outputPath, report, StandardCharsets.UTF_8);
            System.out.println("Relatorio gerado em: " + outputPath.toString());
        } catch (Exception e) {
            System.out.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }
}
