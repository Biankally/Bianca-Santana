import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta classe calcula a mediana de três números inteiros fornecidos pelo usuário,
 * utilizando estruturas condicionais sem realizar uma ordenação explícita.
 */
public class MedianCalculator {

    /**
     * O ponto de entrada principal para a execução do programa.
     */
    public static void main(String[] args) {
        // Usando try-with-resources para garantir que o Scanner seja fechado
        try (Scanner scanner = new Scanner(System.in)) {
            // 1. Solicita ao usuário os três números inteiros
            System.out.print("Digite o primeiro número: ");
            int num1 = scanner.nextInt();

            System.out.print("Digite o segundo número: ");
            int num2 = scanner.nextInt();

            System.out.print("Digite o terceiro número: ");
            int num3 = scanner.nextInt();

            // 2. Chama o método para encontrar a mediana
            int median = findMedian(num1, num2, num3);

            // 3. Exibe o resultado
            System.out.println("A mediana dos números é: " + median);

        } catch (InputMismatchException e) {
            // Trata o caso em que o usuário digita algo que не é um número inteiro
            System.out.println("Erro: Por favor, insira apenas números inteiros válidos.");
        }
    }

    /**
     * Encontra a mediana de três números inteiros usando lógica condicional.
     * Um número é a mediana se ele estiver entre os outros dois (inclusive).
     *
     * @param a O primeiro número inteiro.
     * @param b O segundo número inteiro.
     * @param c O terceiro número inteiro.
     * @return O valor da mediana entre a, b e c.
     */
    public static int findMedian(int a, int b, int c) {
        // Verifica se 'a' é a mediana.
        // Isso acontece se 'a' está entre 'b' e 'c'.
        // Exemplos: (b <= a <= c) ou (c <= a <= b)
        if ((b <= a && a <= c) || (c <= a && a <= b)) {
            return a;
        }
        // Se 'a' не for a mediana, verifica se 'b' é.
        // Isso acontece se 'b' está entre 'a' e 'c'.
        // Exemplos: (a <= b <= c) ou (c <= b <= a)
        else if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return b;
        }
        // Se nem 'a' nem 'b' são a mediana, então 'c' deve ser.
        else {
            return c;
        }
    }
}