import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            SensorMonitor monitor = new SensorMonitor();
            System.out.println("### Monitor de Sensores ###");
            System.out.println("Digite as leituras no formato 'SENSOR_ID;TEMPERATURA' ou 'FIM' para encerrar.");

            String line;
            while (true) {
                System.out.print(">> ");
                line = scanner.nextLine();

                if (line.trim().equalsIgnoreCase("FIM")) { 
                    break;
                }

                try {
                    monitor.addReading(line);
                    System.out.println("Leitura válida adicionada.");
                } catch (InvalidReadingException e) {
                    monitor.incrementIgnoredReadings();
                    System.out.println("ERRO: " + e.getMessage());
                }
            }

            System.out.println("\n--- Resumo ---");
            System.out.println("Leituras válidas processadas: " + monitor.getValidReadingsCount());
            System.out.println("Leituras ignoradas por erro: " + monitor.getIgnoredReadingsCount());

            System.out.println("\nDigite o ID do sensor para ver a média de temperatura (ou 'SAIR' para terminar):");
            while (true) {
                System.out.print(">> ");
                String sensorId = scanner.nextLine();

                if (sensorId.trim().equalsIgnoreCase("SAIR")) {
                    break;
                }

                try {
                    double average = monitor.averageFor(sensorId);
                    System.out.printf("A temperatura média para o sensor '%s' é: %.2f °C%n", sensorId, average);
                } catch (SensorNotFoundException e) {
                    System.out.println("ERRO: " + e.getMessage());
                }
            }
        } finally {
            System.out.println("\nPrograma encerrado.");
        }
    }
}