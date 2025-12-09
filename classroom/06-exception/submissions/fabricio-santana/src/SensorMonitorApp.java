import java.util.Scanner;

public class SensorMonitorApp {

    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();
        Scanner scanner = new Scanner(System.in);
        int invalidCount = 0;

        try {
            apresentarInstrucoes();

            while (true) {
                System.out.print("Informe leitura (ou FIM para encerrar): ");
                String input = scanner.nextLine();

                if ("FIM".equalsIgnoreCase(input.trim())) {
                    break;
                }

                try {
                    monitor.addReading(input);
                    System.out.println("Leitura registrada com sucesso.\n");
                } catch (InvalidReadingException exception) {
                    invalidCount++;
                    System.out.println("Leitura ignorada: " + exception.getMessage() + "\n");
                }
            }

            exibirResumo(monitor, invalidCount);
            consultarMediaPorSensor(scanner, monitor);
        } finally {
            scanner.close();
            System.out.println("Programa encerrado.");
        }
    }

    private static void apresentarInstrucoes() {
        System.out.println("=== Monitor de Sensores ===");
        System.out.println("Informe leituras no formato SENSOR_ID;TEMPERATURA_EM_CELSIUS.");
        System.out.println("Digite FIM para encerrar a coleta.\n");
    }

    private static void exibirResumo(SensorMonitor monitor, int invalidCount) {
        System.out.printf("Leituras válidas registradas: %d%n", monitor.totalReadings());
        System.out.printf("Leituras descartadas: %d%n%n", invalidCount);
    }

    private static void consultarMediaPorSensor(Scanner scanner, SensorMonitor monitor) {
        System.out.print("Consultar média para qual sensor? ");
        String sensorId = scanner.nextLine().trim();

        if (sensorId.isEmpty()) {
            System.out.println("Nenhum sensor informado. Consulta cancelada.\n");
            return;
        }

        try {
            double average = monitor.averageFor(sensorId);
            System.out.printf("Média de %s: %.2f°C%n%n", sensorId, average);
        } catch (SensorNotFoundException exception) {
            System.out.println("Consulta inválida: " + exception.getMessage() + "\n");
        }
    }
}
