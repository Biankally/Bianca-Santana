import java.util.Scanner;
import java.lang.Math;

public class CalculadoraPoligono {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o numero de lados do poligono: ");
        int n = leitor.nextInt();

        System.out.println("Digite o comprimento do lado em metros: ");
        double s = leitor.nextDouble();

        leitor.close();

        double area = calcularArea(n, s);

        System.out.println(formatarSaida(area));

    }

    public static double calcularArea(int n, double s) {
        return (n * s * s) / (4.0 * Math.tan(Math.PI / n));
    }

    public static String formatarSaida(double input) {
        return String.format("A area do poligono é: %.2f metros quadrados", input);
    }
}

