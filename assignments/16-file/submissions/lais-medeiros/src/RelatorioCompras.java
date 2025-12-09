import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Uso correto: java RelatorioCompras <caminho_arquivo_entrada>");
            return;
        }

        Path caminhoEntrada = Path.of(args[0]); 
        
        Path caminhoSaida = Path.of("report.txt");
        
        if (caminhoEntrada.getParent() != null) {
            caminhoSaida = caminhoEntrada.getParent().resolve("report.txt");
        }

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            if (!Files.exists(caminhoEntrada)) {
                System.out.println("Arquivo de entrada não encontrado.");
                return;
            }

            List<String> linhas = Files.readAllLines(caminhoEntrada);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    continue;
                }

                String nomeCliente = partes[0].trim();
                String valorTexto = partes[2].trim();

                try {
                    double valor = Double.parseDouble(valorTexto);

                    int index = clientes.indexOf(nomeCliente);
                    
                    if (index != -1) {
                        totais.set(index, totais.get(index) + valor);
                    } else {
                        clientes.add(nomeCliente);
                        totais.add(valor);
                    }

                } catch (NumberFormatException e) {
                    continue; 
                }
            }

            ArrayList<String> linhasSaida = new ArrayList<>();

            for (int i = 0; i < clientes.size(); i++) {
                linhasSaida.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(caminhoSaida, linhasSaida);

            System.out.println("Relatório gerado com sucesso em: " + caminhoSaida.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }
}