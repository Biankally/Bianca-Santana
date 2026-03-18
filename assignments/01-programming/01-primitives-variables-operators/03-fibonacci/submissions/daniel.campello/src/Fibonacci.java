import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();
        long resultado = calcularFibonacci(n);
        String saida = formatarSaida(resultado, n);
        System.out.println(saida);
    }

    public static long calcularFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long a = 0, b = 1, c;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return b;
        }
    }

    public static String formatarSaida(long numero, int n) {
        return "O " + n + "º número de Fibonacci é: " + numero;
    }
}
