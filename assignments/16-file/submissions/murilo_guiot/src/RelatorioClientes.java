import java.io.IOException;
import java.nio.file.Path;

public class RelatorioClientes {

    public static void main(String[] args) {
        
        if (args.length < 2) {
            System.out.println("Erro: É necessário fornecer os caminhos dos arquivos de entrada e saída.");
            System.out.println("Uso: java RelatorioClientes <caminho_entrada> <caminho_saida>");
            return;
        }

        Path caminhoEntrada = Path.of(args[0]);
        Path caminhoSaida = Path.of(args[1]);

        System.out.println("Processando arquivo de entrada: " + caminhoEntrada.toAbsolutePath());
        System.out.println("Gerando relatório em: " + caminhoSaida.toAbsolutePath());

        ProcessadorRelatorio processador = new ProcessadorRelatorio();

        try {
            processador.gerar(caminhoEntrada, caminhoSaida);
            
            System.out.println("Relatório gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro fatal ao processar arquivos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}