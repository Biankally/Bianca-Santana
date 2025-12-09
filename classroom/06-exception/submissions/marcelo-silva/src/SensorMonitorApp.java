import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SensorMonitor monitor = new SensorMonitor();
        
        int validReadings = 0;
        int invalidReadings = 0;

        try {
            System.out.println("=== Sistema de Monitoramento de Sensores ===");
            System.out.println("Digite as leituras no formato: SENSOR_ID;TEMPERATURA");
            System.out.println("Digite FIM para encerrar a coleta.");
            System.out.println();

            // Coleta de leituras
            while (true) {
                System.out.print("Leitura: ");
                String input = scanner.nextLine();

                // Verifica se o usuário quer encerrar
                if (input.trim().equalsIgnoreCase("FIM")) {
                    break;
                }

                try {
                    monitor.addReading(input);
                    validReadings++;
                    System.out.println("✓ Leitura registrada com sucesso!");
                } catch (InvalidReadingException e) {
                    invalidReadings++;
                    System.out.println("✗ Erro: " + e.getMessage());
                }
                System.out.println();
            }

            // Exibe estatísticas
            System.out.println("\n=== Resumo da Coleta ===");
            System.out.println("Leituras válidas: " + validReadings);
            System.out.println("Leituras ignoradas: " + invalidReadings);
            System.out.println();

            // Consulta de médias
            if (validReadings > 0) {
                System.out.println("=== Consulta de Médias ===");
                System.out.print("Digite o ID do sensor para consultar a média (ou deixe vazio para sair): ");
                String sensorId = scanner.nextLine().trim();

                if (!sensorId.isEmpty()) {
                    try {
                        double average = monitor.averageFor(sensorId);
                        System.out.printf("Temperatura média do sensor %s: %.2f°C%n", sensorId, average);
                    } catch (SensorNotFoundException e) {
                        System.out.println("✗ Erro: " + e.getMessage());
                    }
                }
            }

        } finally {
            scanner.close();
            System.out.println("\nPrograma encerrado.");
        }
    }
}