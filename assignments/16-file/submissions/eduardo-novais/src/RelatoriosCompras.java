import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class RelatoriosCompras {
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java RelatoriosCompras <arquivo_entrada> <arquivo_saida>");
            System.exit(1);
        }
        
        String arquivoEntrada = args[0];
        String arquivoSaida = args[1];
        
        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();
        
        try {
            Path caminhoEntrada = Paths.get(arquivoEntrada);
            List<String> linhas = Files.readAllLines(caminhoEntrada);
            
            for (String linha : linhas) {
                if (linha.trim().isEmpty()) {
                    continue;
                }
                
                String[] campos = linha.split(",");
                
                if (campos.length < 3) {
                    continue;
                }
                
                String nomeCliente = campos[0].trim();
                String valorStr = campos[2].trim();
                
                try {
                    double valor = Double.parseDouble(valorStr);
                    
                    int indice = clientes.indexOf(nomeCliente);
                    
                    if (indice >= 0) {
                        totais.set(indice, totais.get(indice) + valor);
                        continue;
                    }
                    
                    clientes.add(nomeCliente);
                    totais.add(valor);
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            
            StringBuilder conteudoSaida = new StringBuilder();
            for (int i = 0; i < clientes.size(); i++) {
                conteudoSaida.append(clientes.get(i))
                            .append(": ")
                            .append(totais.get(i))
                            .append(System.lineSeparator());
            }
            
            Path diretorioSrc = caminhoEntrada.getParent();
            Path caminhoSaida = diretorioSrc.resolve(arquivoSaida);
            
            Files.writeString(caminhoSaida, conteudoSaida.toString(), 
                            StandardOpenOption.CREATE, 
                            StandardOpenOption.TRUNCATE_EXISTING, 
                            StandardOpenOption.WRITE);
            
            System.out.println("Relatório gerado com sucesso em: " + caminhoSaida);
            
        } catch (java.io.IOException e) {
            System.err.println("Erro ao processar arquivos: " + e.getMessage());
            System.exit(1);
        }
    }
}

