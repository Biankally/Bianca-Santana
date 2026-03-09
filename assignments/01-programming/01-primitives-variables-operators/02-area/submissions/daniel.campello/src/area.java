import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int lados = scanner.nextInt();

        System.out.print("o comprimento do lado em metros: ");
        int comprimento = scanner.nextInt();

        double A = (1.0 / 4) * lados * (Math.pow(comprimento, 2)) / Math.tan(Math.PI / lados);
        System.out.printf("A área do polígono é: %.2f metros quadrados\n", A);
    }
}
