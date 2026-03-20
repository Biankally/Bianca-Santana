import java.util.Scanner;

public class PalindromeChecker {

    // 1. Método para verificar se a entrada é válida (não vazia e não apenas espaços)
    public static boolean isValidInput(String input) {
        // Verifica se a string é nula ou se, após remover os espaços nas pontas, o tamanho é 0
        return input != null && input.trim().length() > 0;
    }

    // 2. Método para verificar se a string é um palíndromo
    public static boolean isPalindrome(String input) {
        // Converte tudo para minúsculas para ignorar diferenças de caixa
        String lowerCaseInput = input.toLowerCase();
        
        int left = 0;
        int right = lowerCaseInput.length() - 1;

        // Compara os caracteres das extremidades em direção ao centro
        while (left < right) {
            if (lowerCaseInput.charAt(left) != lowerCaseInput.charAt(right)) {
                return false; // Se encontrar caracteres diferentes, não é palíndromo
            }
            left++;
            right--;
        }
        
        return true; // Se o loop terminar sem retornar false, é um palíndromo
    }

    // 3. Método principal (Ponto de entrada do programa)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        // Loop para continuar solicitando até que uma entrada válida seja fornecida
        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            } else {
                break; // Sai do loop se a entrada for válida
            }
        }

        // Verifica o palíndromo e exibe o resultado formatado
        if (isPalindrome(input)) {
            System.out.println("A sequência \"" + input + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
        }

        scanner.close();
    }
}