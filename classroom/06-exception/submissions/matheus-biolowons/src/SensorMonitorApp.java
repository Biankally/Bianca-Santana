import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        var monitor = new SensorMonitor();
        int validCount = 0;
        int errorCount = 0;

        try (var scanner = new Scanner(System.in)) {
            System.out.println("Digite as leituras (ID;TEMPERATURA). Digite 'FIM' para encerrar.");

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("FIM"))  break;

                try {
                    monitor.addReading(input);
                    validCount++;
                    System.out.println("Leitura registrada.");
                } catch (InvalidReadingException e) {
                    errorCount++;
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            System.out.println("\n--- Coleta Finalizada ---");
            System.out.println("Leituras válidas: " + validCount);
            System.out.println("Leituras ignoradas: " + errorCount);

            if (monitor.totalReadings() > 0) {
                System.out.print("\nDigite o ID do sensor para consultar a média: ");
                String searchId = scanner.nextLine();

                try {
                    double avg = monitor.averageFor(searchId);
                    System.out.printf("Média térmica do sensor '%s': %.2f°C%n", searchId, avg);
                } catch (SensorNotFoundException e) {
                    System.out.println("Aviso: " + e.getMessage());
                }
            } else {
                System.out.println("Nenhuma leitura válida para consultar.");
            }
        }
    }
}