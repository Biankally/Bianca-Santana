import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class ReportApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java ReportApp <caminho/entrada/compras.txt> <caminho/saida/report.txt>");
            return;
        }

        Path inPath  = Paths.get(args[0]);
        Path outPath = Paths.get(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais   = new ArrayList<>();

        try {
            if (!Files.exists(inPath)) {
                System.out.println("Arquivo de entrada não encontrado: " + inPath);
                return;
            }

            List<String> linhas = Files.readAllLines(inPath, StandardCharsets.UTF_8);
            for (String linha : linhas) {
                if (linha == null) continue;
                linha = linha.trim();
                if (linha.isEmpty()) continue;

                String[] p = linha.split(",", -1);
                if (p.length < 3) {
                    // linha malformada → ignorar
                    continue;
                }

                String nome   = p[0].trim();
                String produto = p[1].trim(); // não usado no total, mas lido conforme formato
                String valorStr = p[2].trim();

                // tenta parsear; se falhar com ponto, tenta trocar vírgula por ponto
                Double valor;
                try {
                    valor = Double.parseDouble(valorStr);
                } catch (NumberFormatException e1) {
                    try {
                        valor = Double.parseDouble(valorStr.replace(',', '.'));
                    } catch (NumberFormatException e2) {
                        // conversão numérica inválida → ignorar linha
                        continue;
                    }
                }

                int idx = clientes.indexOf(nome);
                if (idx < 0) {
                    clientes.add(nome);
                    totais.add(valor);
                } else {
                    totais.set(idx, totais.get(idx) + valor);
                }
            }

            ArrayList<String> saida = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                saida.add(clientes.get(i) + ": " + totais.get(i));
            }

            if (outPath.getParent() != null) {
                Files.createDirectories(outPath.getParent());
            }
            Files.write(outPath, saida, StandardCharsets.UTF_8, CREATE, TRUNCATE_EXISTING);

            System.out.println("Relatório gerado em: " + outPath.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Falha de I/O: " + e.getMessage());
        }
    }
}
