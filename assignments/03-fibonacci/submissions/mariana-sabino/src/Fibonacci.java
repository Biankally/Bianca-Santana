import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um numero inteiro nao negativo: ");
        int n = leitor.nextInt();

        long resultado = calcularFibonacci(n);

        System.out.println(formatarSaida(resultado, n));

        leitor.close();


    }

    public static long calcularFibonacci(int n) {
        if (n < 2){
            return n;
        }
        
       long a = 0, b = 1;
       for (int i = 2; i <= n; i++){
        long temp = a + b;
        a = b;
        b = temp;

       }
       return b;
    }

    public static String formatarSaida(long input, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, input);
    }
}

