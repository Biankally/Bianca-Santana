import java.util.Locale;
import java.util.Scanner;

public class SensorMonitorApp {

    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();
        int ignoredReadingsCount = 0;
        String line = "";

        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.println(" MONITOR DE TEMPERATURAS ");
            System.out.println("digite as leituras no formato: SENSOR_ID;TEMPERATURA_EM_CELSIUS");
            System.out.println("digite 'FIM' para encerrar a coleta.");
            
            while (true) {
                System.out.print("> ");
                line = scanner.nextLine().trim();

                if (line.equalsIgnoreCase("FIM")) {
                    break;
                }

                if (line.isEmpty()) {
                    continue;
                }

                try {
                    monitor.addReading(line);
                    System.out.println("leitura armazenada com sucesso.");
                } catch (InvalidReadingException e) {
                    System.err.println("ERRO: leitura inválida! " + e.getMessage());
                    ignoredReadingsCount++;
                } catch (Exception e) {
                    System.err.println("ERRO INESPERADO: ocorreu um problema ao processar a leitura: " + e.getMessage());
                    ignoredReadingsCount++;
                }
            }
            
            long validReadingsCount = monitor.getTotalValidReadingsCount();
            System.out.println("\n resumo da coleta ");
            System.out.println("total de leituras válidas: " + validReadingsCount);
            System.out.println("total de leituras ignoradas por erro: " + ignoredReadingsCount);
            
            System.out.println("\n consulta de média ");
            System.out.println("digite o ID do sensor para consultar a média ou 'SAIR' para terminar.");
            
            while (true) {
                System.out.print("ID do sensor: ");
                String sensorQuery = scanner.nextLine().trim();

                if (sensorQuery.equalsIgnoreCase("SAIR")) {
                    break;
                }
                
                if (sensorQuery.isEmpty()) {
                    continue;
                }

                try {
                    double average = monitor.averageFor(sensorQuery);
                    System.out.printf("média de temperatura para '%s': %.2f°C\n", sensorQuery, average);
                } catch (SensorNotFoundException e) {
                    System.err.println("ERRO: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.err.println("\nERRO CRÍTICO: o programa será encerrado devido a um erro inesperado.");
            e.printStackTrace();
        } finally {
            System.out.println("\nprograma encerrado.");
        }
    }
}