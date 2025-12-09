import java.util.Scanner;

public class SensorMonitorApp {

    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();
        Scanner scanner = new Scanner(System.in);
        int validReadingsCount = 0;
        int ignoredReadingsCount = 0;

        try {
            System.out.println("----------------------------------------");
            System.out.println("   Monitor de Leituras de Temperatura   ");
            System.out.println("----------------------------------------");
            System.out.println("Instruções:");
            System.out.println("1. Digite as leituras no formato: ID_DO_SENSOR;TEMPERATURA (formato 'sensor-exemplo;temperatura')");
            System.out.println("2. Digite 'FIM' para encerrar a coleta de dados.");


            String input;
            while (true) {
                System.out.print("Leitura > ");
                input = scanner.nextLine();

                if ("FIM".equalsIgnoreCase(input.trim())) {
                    break;
                }

                try {
                    monitor.addReading(input);
                    validReadingsCount++;
                    System.out.println("✓ Leitura válida registrada.\n");
                } catch (InvalidReadingException e) {
                    ignoredReadingsCount++;
                    System.out.println("✗ Leitura inválida. Motivo: " + e.getMessage());
                    System.out.println("Por favor, tente novamente.\n");
                }
            }

            System.out.println("\n--- Fim da Coleta de Dados ---");
            System.out.println("Total de leituras válidas registradas: " + validReadingsCount);
            System.out.println("Leituras ignoradas por erro: " + ignoredReadingsCount);
            System.out.println("------------------------------\n");

            System.out.println("--- Consulta de Temperatura Média ---");
            System.out.println("Digite o ID de um sensor para ver sua média.");
            System.out.println("\nExemplo de consulta:");
            System.out.println("   sensor-01");
            System.out.print("ID do Sensor > ");
            String sensorId = scanner.nextLine();

            try {
                double average = monitor.averageFor(sensorId.trim());
                System.out.printf("A temperatura média para o sensor '%s' é: %.2f°C%n", sensorId, average);
            } catch (SensorNotFoundException e) {
                System.out.println("Nenhuma leitura encontrada para o ID '" + sensorId + "'.");
                System.out.println("Verifique se o ID foi digitado corretamente.");
            }

        } finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("\nPrograma encerrado.");
        }
    }
}