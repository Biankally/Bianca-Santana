import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RelatorioCompras {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompras <caminho/entrada.txt> <caminho/saida.txt>");
            return;
        }

        Path inPath = Paths.get(args[0]);
        Path outPath = Paths.get(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(inPath, StandardCharsets.UTF_8);

            for (String linha : linhas) {
                if (linha == null) continue;
                String raw = linha.trim();
                if (raw.isEmpty()) continue;

                String[] partes = raw.split(",", -1); 
                if (partes.length < 3) {
                    continue;
                }

                String nome = partes[0].trim();
                String produto = partes[1].trim();
                String valorStr = partes[2].trim();

                if (nome.isEmpty() || produto.isEmpty() || valorStr.isEmpty()) {
                    continue;
                }

                double valor;
                try {
                    valor = Double.parseDouble(valorStr.replace(',', '.'));
                } catch (NumberFormatException nfe) {
                    continue;
                }

                int idx = clientes.indexOf(nome); 
                if (idx >= 0) {
                    totais.set(idx, totais.get(idx) + valor);
                } else {
                    clientes.add(nome);
                    totais.add(valor);
                }
            }

            ArrayList<String> saida = new ArrayList<>(clientes.size());
            Locale locale = Locale.US; 
            for (int i = 0; i < clientes.size(); i++) {
                String linhaOut = String.format(locale, "%s: %.2f", clientes.get(i), totais.get(i));
                saida.add(linhaOut);
            }

            Path parent = outPath.getParent();
            if (parent != null) Files.createDirectories(parent);
            Files.write(outPath, saida, StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Relatório gerado em: " + outPath.toAbsolutePath());

        } catch (IOException ioe) {
            System.out.println("Erro de I/O: " + ioe.getMessage());
        }
    }
}
