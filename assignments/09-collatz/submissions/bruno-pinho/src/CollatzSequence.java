import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta classe calcula a Sequência de Collatz para um número inteiro positivo
 * fornecido pelo usuário e a soma de todos os seus termos.
 */
public class CollatzSequence {

    /**
     * Método principal que serve como ponto de entrada do programa.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro positivo: ");
            int n = scanner.nextInt();

            // 1. Valida a entrada do usuário
            if (n < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
                return; // Encerra o programa se a entrada for inválida
            }

            // 2. Imprime a sequência e calcula a soma simultaneamente
            // Usamos 'long' para a soma para evitar estouro de inteiro (overflow) com sementes grandes.
            long sum = 0;
            int currentNumber = n;

            System.out.print("Sequência de Collatz: ");

            // 3. Usa um loop 'while' para gerar a sequência até chegar a 1
            while (currentNumber != 1) {
                System.out.print(currentNumber + " → ");
                sum += currentNumber;
                currentNumber = nextCollatz(currentNumber);
            }

            // Adiciona o último termo (1) e o imprime
            System.out.println(1);
            sum += 1;

            // 4. Exibe a soma total
            System.out.println("Soma dos termos: " + sum);

        } catch (InputMismatchException e) {
            // Captura o erro se o usuário digitar algo que не é um inteiro
            System.out.println("Erro: Entrada inválida. Por favor, digite um número inteiro.");
        }
    }

    /**
     * Calcula o próximo número na sequência de Collatz.
     *
     * @param n O número atual na sequência (deve ser positivo).
     * @return O próximo número na sequência.
     */
    public static int nextCollatz(int n) {
        // Se n for par, divida por 2
        if (n % 2 == 0) {
            return n / 2;
        } 
        // Se n for ímpar, multiplique por 3 e adicione 1
        else {
            return (n * 3) + 1;
        }
    }

    /**
     * Gera a sequência de Collatz a partir de n e retorna a soma de todos os termos.
     * Nota: Este método é fornecido para cumprir os requisitos, mas a implementação
     * no 'main' é mais eficiente, pois calcula e imprime na mesma passagem.
     *
     * @param n O número inicial (semente) da sequência.
     * @return A soma de todos os termos da sequência como um 'long'.
     */
    public static long calculateCollatzSum(int n) {
        if (n < 1) {
            return 0; // Retorna 0 para entradas inválidas
        }

        long sum = 0;
        int currentNumber = n;

        while (currentNumber != 1) {
            sum += currentNumber;
            currentNumber = nextCollatz(currentNumber);
        }
        sum += 1; // Adiciona o último termo (1) à soma

        return sum;
    }
}