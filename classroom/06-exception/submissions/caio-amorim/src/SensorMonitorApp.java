import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SensorMonitor monitor = new SensorMonitor();

        int invalidCount = 0;

        try {
            while (true) {
                System.out.print("Digite a leitura (ou FIM para encerrar): ");
                String line = sc.nextLine();

                if (line.equalsIgnoreCase("FIM")) break;

                try {
                    monitor.addReading(line);
                    System.out.println("Leitura registrada com sucesso!");
                } catch (InvalidReadingException e) {
                    invalidCount++;
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            System.out.println("\nLeituras válidas: " + monitor.totalReadings());
            System.out.println("Leituras inválidas: " + invalidCount);

            System.out.print("\nInforme o sensor para consultar a média: ");
            String id = sc.nextLine();

            try {
                double media = monitor.averageFor(id);
                System.out.printf("Temperatura média do sensor %s: %.2f°C%n", id, media);
            } catch (SensorNotFoundException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } finally {
            System.out.println("\nPrograma encerrado.");
            sc.close();
        }
    }
}
