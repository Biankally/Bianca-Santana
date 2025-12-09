import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        int destino = entrada.nextInt();
        entrada.close(); // Adição correta

        if (destino < 1 || destino > 1_000_000) {
            System.out.println("Erro: a posição deve estar entre 1 e 1.000.000.");
            return;
        }

        int passosMinimos = calcularPassosMinimos(destino);
        String mensagem = formatarSaida(passosMinimos);
        System.out.println(mensagem);
    }

    public static int calcularPassosMinimos(int destino) {
        // Lógica do teto: (a + b - 1) / b, onde a=destino e b=5
        return (destino + 4) / 5;
    }

    public static String formatarSaida(int passosMinimos) {
        if (passosMinimos == 1) {
            return "O elefante precisa de " + passosMinimos + " passo.";
        } else {
            return "O elefante precisa de " + passosMinimos + " passos.";
        }
    }
}
