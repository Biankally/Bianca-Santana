import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorRelatorio {

    private ArrayList<String> nomesClientes = new ArrayList<>();
    private ArrayList<Double> totaisCompras = new ArrayList<>();

    public void gerar(Path caminhoEntrada, Path caminhoSaida) throws IOException {
        
        List<String> todasLinhas = Files.readAllLines(caminhoEntrada);

        processarLinhas(todasLinhas);

        List<String> linhasRelatorio = formatarSaida();

        Files.write(caminhoSaida, linhasRelatorio);
    }

    private void processarLinhas(List<String> linhas) {
        
        for (String linha : linhas) {
            String[] campos = linha.split(",");

            if (campos.length < 3) {
                System.out.println("AVISO: Linha malformada ignorada: '" + linha + "'");
                continue;
            }

            String nomeCliente = campos[0].trim();
            String valorCompraStr = campos[2].trim();
            double valorCompra;

            try {
                valorCompra = Double.parseDouble(valorCompraStr);
            } catch (NumberFormatException e) {
                System.out.println("AVISO: Valor numérico inválido na linha: '" + linha + "'");
                continue;
            }

            int indiceCliente = nomesClientes.indexOf(nomeCliente);

            if (indiceCliente == -1) {
                nomesClientes.add(nomeCliente);
                totaisCompras.add(valorCompra);
            } else {
                double totalAtual = totaisCompras.get(indiceCliente);
                double novoTotal = totalAtual + valorCompra;
                totaisCompras.set(indiceCliente, novoTotal);
            }
        }
    }

    private List<String> formatarSaida() {
        ArrayList<String> linhasSaida = new ArrayList<>();
        
        for (int i = 0; i < nomesClientes.size(); i++) {
            String nome = nomesClientes.get(i);
            Double total = totaisCompras.get(i);

            String linhaSaida = String.format("%s: %.2f", nome, total);
            linhasSaida.add(linhaSaida);
        }
        return linhasSaida;
    }
}