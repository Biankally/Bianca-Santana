import java.util.Scanner;

public class IMC {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        double peso;
        double altura;
        double IMC;

        System.out.println("Digite o seu peso: ");
        peso = input.nextDouble();

        System.out.println("Digite sua altura: ");
        altura = input.nextDouble();

        IMC = peso / (altura * altura);

        System.out.println("O seu IMC é: " + IMC);

        if(IMC > 25){
            System.out.println("Você está acima do peso.");
        }

        if(IMC < 18 ){
            System.out.println("Você está abaixo do peso.");
        }

        if(IMC >= 18 && IMC <= 25){
            System.out.println("Você está no peso ideal.");
        }

    }
}