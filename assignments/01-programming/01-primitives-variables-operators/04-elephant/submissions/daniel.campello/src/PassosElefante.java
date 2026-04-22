import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");

        if(!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido.");
            return;
        }
 
        int x = scanner.nextInt();
        int upperbound = 1000000;
        int lowerbound = 1;

        if (x < lowerbound || x > upperbound) {
            System.out.println("A distância deve ser entre " + lowerbound + " e " + upperbound + " metros.");
        } else {
            // 2. Só calcule se o valor for válido
            int passos = calcularPassosMinimos(x);
            formataSaida(passos, x);
        }
        
        scanner.close();
    }
    
    public static int calcularPassosMinimos(int distancia) {
        // Lógica: se sobrar resto, soma 1 ao resultado da divisão
        if (distancia % 5 == 0) {
            return distancia / 5;
        } else {
            return (distancia / 5) + 1;
        }
    }    public static int formataSaida(int passos, int distancia) {
        System.out.println("O número mínimo de passos necessários é: " + passos);
        return passos;
    }
}
