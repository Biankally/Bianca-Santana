import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int posicao = leitor.nextInt();


        int passos = calcularPassosMinimos(posicao);
        System.out.println(formatarSaida(passos));

}

    public static  int calcularPassosMinimos(int posicao) {
        int passosCompletos = posicao / 5;

        
        if (posicao % 5 != 0) passosCompletos++;

        return passosCompletos;
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}
