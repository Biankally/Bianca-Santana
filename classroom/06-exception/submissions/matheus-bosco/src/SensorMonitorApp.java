import java.util.Scanner;


public class SensorMonitorApp {


    public static void main(String[] args) {
        
        SensorMonitor monitor = new SensorMonitor();

        int ignoradas = 0;  


        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("----Monitor de sensores----");
            System.out.println("Digite FIM para encerrar a coleta de temperaturas");


            while (true) {

                System.out.print("> ");

                String linha = scanner.nextLine();

                if (linha == null) break; 

                if ("FIM".equalsIgnoreCase(linha.trim())) break;

                try {
                    monitor.addReading(linha);
                    System.out.println("Leitura registrada.");

                } catch (InvalidReadingException e) {
                    ignoradas++;
                    System.out.println("Leitura ignorada: " + e.getMessage());
                }
            }

            System.out.println("\nColeta encerrada.");
            System.out.println("Leituras válidas: " + monitor.totalReadings());
            System.out.println("Leituras ignoradas por erro: " + ignoradas);
            System.out.println("Sensores com leituras: " + monitor.totalSensors());
            if (monitor.totalSensors() > 0) {
                System.out.println("IDs: " + monitor.sensors());
            }

           
            System.out.print("\nConsultar média de qual sensor? (ENTER para pular) ");

            String id = scanner.nextLine().trim();

            if (!id.isEmpty()) {
                try {
                    double media = monitor.averageFor(id);
                    System.out.printf("Média do sensor '%s': %.2f °C%n", id, media);
                } catch (SensorNotFoundException e) {
                    System.out.println("Não foi possível calcular a média: " + e.getMessage());
                }
            } else {
                System.out.println("Consulta de média ignorada.");
            }

        } catch (Exception e) {
            
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            System.out.println("Programa encerrado.");
        }
    }
}
