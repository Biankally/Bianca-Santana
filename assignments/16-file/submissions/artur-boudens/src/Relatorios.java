import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Relatorios {
    public static void main(String[] args) {
        String arquivoEntrada = "compras.txt";
        String arquivoSaida = "report.txt";

        if (args.length >= 2) {
            arquivoEntrada = args[0];
            arquivoSaida = args[1];
        }

        Path pathEntrada = Paths.get(arquivoEntrada);
        Path pathSaida = Paths.get(arquivoSaida);

        ArrayList<String> nomesClientes = new ArrayList<>();
        ArrayList<Double> totaisCompras = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(pathEntrada);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    continue;
                }

                String nome = partes[0];
                String valorStr = partes[2];

                try {
                    double valor = Double.parseDouble(valorStr);
                    int index = -1;

                    for (int i = 0; i < nomesClientes.size(); i++) {
                        if (nomesClientes.get(i).equals(nome)) {
                            index = i;
                            break;
                        }
                    }

                    if (index != -1) {
                        double valorAtual = totaisCompras.get(index);
                        totaisCompras.set(index, valorAtual + valor);
                    } else {
                        nomesClientes.add(nome);
                        totaisCompras.add(valor);
                    }

                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                }
            }

            List<String> linhasSaida = new ArrayList<>();
            for (int i = 0; i < nomesClientes.size(); i++) {
                linhasSaida.add(nomesClientes.get(i) + ": " + totaisCompras.get(i));
            }

            Files.write(pathSaida, linhasSaida);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
