import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge = 2.0;
        if (hours > 3)
            charge += (Math.ceil(hours) - 3) * 0.5;
        if (charge > 10.0)
            charge = 10.0;
        return charge;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = sc.nextDouble();
            if (horas == -1)
                break;

            double taxa = calculateCharges(horas);
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, taxa);
            total += taxa;
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);
        sc.close();
    }
}
