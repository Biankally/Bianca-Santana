
import java.util.Scanner; // importa a classe scanenr, disponivel no pacote java.util

public class ScannerSample { 

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); //Scanner é um tipo do java(tipo complexo) --> construiu um novo tipo de Scanner com parametro de um tipo de entrada

        System.out.print("Informe um inteiro: ");
        int i = input.nextInt(); // le o proximo valor como exemplo
        System.out.printf("Valor informado: %d%n", i); // %d inteiros

        System.out.print("Informe um double: ");
        double d = input.nextDouble();
        System.out.printf("Valor informado: %.3f%n", d); // %f números reais com X casas decimais 

        System.out.print("Informe um float: ");
        float f = input.nextFloat();
        System.out.printf("Valor informado: %.5f%n", f); // %f números reais com X casas decimais 

        System.out.print("Informe um boolean: ");
        boolean b = input.nextBoolean();
        System.out.printf("Valor informado: %b%n", b); // %b boleanos

        System.out.print("Informe um texto: ");
        String s = input.next(); // next lê o proximo valor como string
        System.out.printf("Valor informado: %s%n", s); // %s String

        input.nextLine();
        
        System.out.print("Informe um texto: ");
        s = input.nextLine();
        System.out.printf("Valor informado: %s%n", s); // %s String

        input.close(); // input close fecha o Scanner e a conexão com Sytem.in
        System.out.print("Fim");
    }
    
}
