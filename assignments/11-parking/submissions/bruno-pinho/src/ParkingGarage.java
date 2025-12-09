import java.util.Locale;
import java.util.Scanner;

/**
 * Esta classe simula um sistema de cobrança para uma garagem de estacionamento.
 * Ela calcula a taxa para cada cliente com base nas horas de permanência e
 * mantém um total diário das receitas.
 */
public class ParkingGarage {

    // Constantes para as regras de cobrança, facilitando a manutenção
    private static final double MINIMUM_FEE = 2.00;
    private static final double HOURS_FOR_MINIMUM_FEE = 3.0;
    private static final double ADDITIONAL_HOURLY_FEE = 0.50;
    private static final double MAXIMUM_FEE = 10.00;
    private static final double MAX_HOURS_IN_DAY = 24.0;

    /**
     * O método principal que gerencia a interação com o usuário e o fluxo do programa.
     */
    public static void main(String[] args) {
        // Define o Locale para US para garantir que o ponto seja o separador decimal
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        double totalReceipts = 0.0;
        int customerCount = 1;

        System.out.println("--- Sistema de Cobrança de Estacionamento ---");
        
        // Loop para processar múltiplos clientes
        while (true) {
            System.out.printf("Digite o número de horas estacionadas para o cliente %d (ou -1 para sair): ", customerCount);
            double hours = scanner.nextDouble();

            // Condição de saída do loop
            if (hours == -1) {
                break;
            }

            // Validação da entrada de horas
            if (hours <= 0 || hours > MAX_HOURS_IN_DAY) {
                System.out.println("Entrada inválida. As horas devem ser entre 0 (exclusive) e 24 (inclusive).\n");
                continue; // Pula para a próxima iteração
            }

            // Chama o método para calcular a taxa
            double charge = calculateCharges(hours);
            
            // Adiciona a taxa ao total arrecadado
            totalReceipts += charge;

            // Exibe a taxa para o cliente atual
            System.out.printf("Taxa de estacionamento: R$%.2f\n\n", charge);
            
            customerCount++;
        }

        // Exibe o total arrecadado no dia
        System.out.printf("Total arrecadado ontem: R$%.2f\n", totalReceipts);

        scanner.close();
    }

    /**
     * Calcula a taxa de estacionamento com base no número de horas de permanência.
     *
     * @param hours As horas que o carro ficou estacionado.
     * @return O valor (double) da taxa a ser cobrada.
     */
    public static double calculateCharges(double hours) {
        double charge = MINIMUM_FEE;

        // Arredonda as horas para cima para lidar com "frações de hora"
        double roundedHours = Math.ceil(hours);

        // Calcula a cobrança adicional se o tempo exceder o mínimo
        if (roundedHours > HOURS_FOR_MINIMUM_FEE) {
            double extraHours = roundedHours - HOURS_FOR_MINIMUM_FEE;
            charge += extraHours * ADDITIONAL_HOURLY_FEE;
        }

        // Garante que a cobrança não exceda a taxa máxima
        // Math.min retorna o menor de dois valores, efetivamente aplicando um teto.
        return Math.min(charge, MAXIMUM_FEE);
    }
}