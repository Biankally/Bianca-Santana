import java.util.Scanner;

public class imc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu peso em kg: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        double imc = peso / (altura * altura);

        System.out.printf("Seu IMC é: %.2f\n", imc);

        if (imc < 18.5) {
            System.out.println("Classificação: Abaixo do peso");
        } else if (imc >= 18.5 && imc < 25) {
            System.out.println("Classificação: Eutrófico");
        } else if (imc >= 25 && imc < 30) {
            System.out.println("Classificação: Sobrepeso");
        } else if (imc >= 30 && imc < 35) {
            System.out.println("Classificação: Obesidade grau I");
        } else if (imc >= 35 && imc < 40) {
            System.out.println("Classificação: Obesidade grau II");
        } else {
            System.out.println("Classificação: Obesidade grau III");
        }

        scanner.close();
    }
}

//* Abaixo do peso: IMC < 18.50
//* Eutrófico: 18.5 ≤ IMC < 24.99
//* Sobrepeso: 25.0 ≤ IMC < 29.99
//* Obesidade grau I: 30.0 ≤ IMC < 34.99
//* Obesidade grau II: 35.0 ≤ IMC < 39.99
//* Obesidade grau III: IMC ≥ 40.0
