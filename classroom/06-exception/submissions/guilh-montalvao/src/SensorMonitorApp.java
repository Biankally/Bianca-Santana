import java.util.Locale;
import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            SensorMonitor monitor = new SensorMonitor();

            while (true) {
                String line = scanner.nextLine();
                if (line == null) {
                    break;
                }
                String trimmed = line.trim();
                if (trimmed.isEmpty()) {
                    continue;
                }
                if (trimmed.equalsIgnoreCase("FIM")) {
                    break;
                }
                try {
                    monitor.addReading(trimmed);
                } catch (InvalidReadingException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Leituras validas: " + monitor.getValidCount() +
                    " | Leituras ignoradas por erro: " + monitor.getInvalidCount());

            String sensorPrompt = scanner.nextLine();
            String sensorId = sensorPrompt == null ? "" : sensorPrompt.trim();
            if (!sensorId.isEmpty()) {
                try {
                    double avg = monitor.averageFor(sensorId);
                    System.out.println(String.format(Locale.US, "Media do sensor %s: %.2f C", sensorId, avg));
                } catch (SensorNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            System.out.println("Programa encerrado.");
        }
    }
}
