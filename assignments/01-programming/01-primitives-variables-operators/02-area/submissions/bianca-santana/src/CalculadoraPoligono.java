import java.util.Scanner;


public class CalculadoraPoligono {

public static void main (String[] arg){
    
    Scanner ler = new Scanner(System.in);

    System.out.printf("Digite o número de lados do polígono:");
    int plg = ler.nextInt();

    System.out.printf("Digite o comprimento do lado em metros:");
    double ld = ler.nextDouble();

   String A = formatarSaida(calcularArea(plg, ld));
  
    System.out.printf("A área do polígono é: %s metros quadrados%n", A);
}

public static double calcularArea (int n, double s){
    double area = (n*(s*s))/(4.0*Math.tan(Math.PI/n));
    return area;
}

public static String formatarSaida (double p){
    String fmt = String.format("%.2f", p);
     return fmt;
}

}