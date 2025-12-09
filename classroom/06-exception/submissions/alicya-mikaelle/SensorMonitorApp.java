import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SensorMonitor monitor = new SensorMonitor();

        int leiturasInvalidas = 0;

        try {
            System.out.println("Digite as leituras no formato SENSOR_ID;TEMPERATURA (ou FIM para encerrar):");

            while (true) {
                String linha = scanner.nextLine().trim();

                if (linha.equalsIgnoreCase("FIM")) {
                    break;
                }

                try {
                    monitor.addReading(linha);
                    System.out.println("Leitura registrada com sucesso!");
                } catch (InvalidReadingException e) {
                    System.out.println("Erro: " + e.getMessage());
                    leiturasInvalidas++;
                }
            }

            System.out.println("\nResumo:");
            System.out.println("Leituras válidas: " + monitor.totalReadings());
            System.out.println("Leituras inválidas: " + leiturasInvalidas);

            // Consulta média
            System.out.print("\nDigite o ID do sensor para consultar a média: ");
            String sensorId = scanner.nextLine();

            try {
                double media = monitor.averageFor(sensorId);
                System.out.printf("Temperatura média do sensor %s: %.2f°C%n", sensorId, media);
            } catch (SensorNotFoundException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } finally {
            System.out.println("\nPrograma encerrado.");
            scanner.close();
        }
    }
}
