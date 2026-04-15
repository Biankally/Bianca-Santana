import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
        double charge = 0.0;
        if (hours <= 3) {
            charge = 2.0;
        } else if (hours > 3 && hours <= 24) {
            charge = 2.0 + (hours - 3) * 0.5;
        } else {
            charge = 10.0;
        }
        return math.min(charge, 10.0); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalArrecadado = 0.0;
        int clienteCount = 0;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hoursParked = scanner.nextDouble();

            if (hoursParked == -1) {
                break;
            }

            double currentCharge = calculateCharges(hoursParked);
            System.out.println("Cliente " + (++clienteCount) + ": Taxa de estacionamento: $" + currentCharge);
            totalArrecadado += currentCharge;
        }
        System.out.println("Total arrecadado ontem: $" + totalArrecadado);
    }
}
