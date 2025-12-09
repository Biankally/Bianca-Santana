// SensorMonitorApp.java
import java.util.Scanner;

public class SensorMonitorApp {

    public static void main(String[] args) {
        // O bloco try-finally garante que a mensagem final sempre seja exibida.
        try {
            // O try-with-resources garante que o Scanner seja fechado automaticamente.
            try (Scanner scanner = new Scanner(System.in)) {
                SensorMonitor monitor = new SensorMonitor();
                int invalidReadingsCount = 0;

                System.out.println("--- Monitor de Sensores ---");
                System.out.println("Digite as leituras no formato SENSOR_ID;TEMPERATURA (ex: T1;23.5)");
                System.out.println("Digite 'FIM' para encerrar a coleta de dados.");

                // Laço de coleta de leituras
                while (true) {
                    System.out.print("> ");
                    String line = scanner.nextLine();

                    if ("FIM".equalsIgnoreCase(line)) {
                        break;
                    }

                    try {
                        monitor.addReading(line);
                    } catch (InvalidReadingException e) {
                        System.out.println("Leitura inválida: " + e.getMessage());
                        invalidReadingsCount++;
                    }
                }

                System.out.println("\n--- Resumo da Coleta ---");
                System.out.println("Leituras válidas recebidas: " + monitor.getTotalReadings());
                System.out.println("Leituras inválidas ignoradas: " + invalidReadingsCount);

                // Laço de consulta de médias
                System.out.println("\n--- Consulta de Médias ---");
                System.out.println("Digite o ID de um sensor para ver sua média ou 'SAIR' para terminar.");
                while (true) {
                    System.out.print("Consultar sensor: ");
                    String sensorIdToQuery = scanner.nextLine();

                    if ("SAIR".equalsIgnoreCase(sensorIdToQuery)) {
                        break;
                    }

                    try {
                        double average = monitor.averageFor(sensorIdToQuery);
                        // Usando printf para formatar a saída com 2 casas decimais
                        System.out.printf("Média para o sensor '%s': %.2f°C%n", sensorIdToQuery, average);
                    } catch (SensorNotFoundException e) {
                        System.out.println("Erro na consulta: " + e.getMessage());
                    }
                }
            }
        } finally {
            System.out.println("\nPrograma encerrado.");
        }
    }
}