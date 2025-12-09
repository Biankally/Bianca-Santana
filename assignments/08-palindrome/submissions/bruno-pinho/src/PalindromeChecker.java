import java.util.Scanner;

/**
 * Esta classe fornece funcionalidades para verificar se uma dada sequência de
 * caracteres é um palíndromo.
 */
public class PalindromeChecker {

    /**
     * O método principal que executa o programa.
     * Ele solicita a entrada do usuário, valida e verifica se é um palíndromo.
     */
    public static void main(String[] args) {
        // Usando try-with-resources para garantir que o Scanner seja fechado automaticamente
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput;

            // Loop infinito que continua até que uma entrada válida seja fornecida
            while (true) {
                System.out.print("Digite uma sequência: ");
                userInput = scanner.nextLine();

                // 1. Valida a entrada do usuário
                if (isValidInput(userInput)) {
                    // Se a entrada for válida, sai do loop
                    break;
                } else {
                    // Se for inválida, exibe uma mensagem de erro e o loop continua
                    System.out.println("Erro: A entrada не pode estar vazia.");
                }
            }

            // 2. Remove espaços em branco do início e do fim para a verificação
            String cleanInput = userInput.trim();

            // 3. Verifica se a entrada limpa é um palíndromo
            if (isPalindrome(cleanInput)) {
                System.out.printf("A sequência \"%s\" é um palíndromo.\n", cleanInput);
            } else {
                System.out.printf("A sequência \"%s\" não é um palíndromo.\n", cleanInput);
            }
        }
    }

    /**
     * Verifica se a entrada do usuário é válida.
     * Uma entrada é válida se não for nula e não estiver completamente em branco.
     *
     * @param input A string a ser validada.
     * @return true se a entrada for válida, caso contrário, false.
     */
    public static boolean isValidInput(String input) {
        // A entrada é válida se não for nula E se, após remover os espaços
        // das pontas, a string não estiver vazia.
        return input != null && !input.trim().isEmpty();
    }

    /**
     * Verifica se uma string é um palíndromo.
     * A verificação ignora diferenças entre maiúsculas e minúsculas.
     *
     * @param input A string a ser verificada.
     * @return true se a string for um palíndromo, caso contrário, false.
     */
    public static boolean isPalindrome(String input) {
        // Converte a string para minúsculas para ignorar diferenças de caso
        String processedInput = input.toLowerCase();

        int left = 0; // Ponteiro para o início da string
        int right = processedInput.length() - 1; // Ponteiro para o fim da string

        // Compara os caracteres das extremidades para o centro
        while (left < right) {
            // Se os caracteres nas posições 'left' e 'right' forem diferentes,
            // não é um palíndromo.
            if (processedInput.charAt(left) != processedInput.charAt(right)) {
                return false;
            }

            // Move os ponteiros em direção ao centro
            left++;
            right--;
        }

        // Se o loop terminar sem encontrar diferenças, é um palíndromo.
        return true;
    }
}