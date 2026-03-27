import java.util.Scanner;

public class calculadoraPoligono {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int lados = ler.nextInt();

        System.out.print("Digite a medida do lado em metros: ");
        double medidaLado = ler.nextDouble();

        double area = calcularAreaPoligono(lados, medidaLado);
        System.out.printf("A área do polígono é: %.2f metros quadrados%n", area);
    }

    public static double calcularAreaPoligono(int lados, double medidaLado) {
        if (lados < 3) {
            System.out.println("Um polígono deve ter pelo menos 3 lados.");
            return 0;
        }
        double apotema = medidaLado / (2 * Math.tan(Math.PI / lados));
        return (lados * medidaLado * apotema) / 2;
    }
}
