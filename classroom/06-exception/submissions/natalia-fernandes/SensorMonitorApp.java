import java.util.Scanner;

public class SensorMonitorApp {

    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();
        Scanner scanner = new Scanner(System.in);

        int leiturasInvalidas = 0;

        try {
            System.out.println("=== Monitor de Sensores ===");
            System.out.println("Digite leituras no formato SENSOR_ID;TEMPERATURA_EM_CELSIUS");
            System.out.println("Para encerrar a entrada de leituras, digite: FIM\n");

            while (true) {
                System.out.print("Leitura: ");
                String line = scanner.nextLine();

                if (line.equalsIgnoreCase("FIM")) {
                    break;
                }

                try {
                    monitor.addReading(line);
                    System.out.println("Leitura registrada com sucesso.\n");
                } catch (InvalidReadingException e) {
                    leiturasInvalidas++;
                    System.out.println("Leitura inválida: " + e.getMessage() + "\n");
                    // continua o laço, não encerra o programa
                }
            }

            // Resumo das leituras
            int validas = monitor.getTotalValidReadings();
            System.out.println("\nColeta encerrada.");
            System.out.println("Leituras válidas   : " + validas);
            System.out.println("Leituras ignoradas : " + leiturasInvalidas + "\n");

            // Consulta de média
            if (validas > 0) {
                System.out.print("Informe o ID do sensor para consultar a média: ");
                String sensorId = scanner.nextLine();

                try {
                    double media = monitor.averageFor(sensorId);
                    System.out.printf("Temperatura média do sensor %s: %.2f °C%n",
                            sensorId, media);
                } catch (SensorNotFoundException e) {
                    System.out.println("Erro na consulta: " + e.getMessage());
                }
            } else {
                System.out.println("Não há leituras válidas para consulta de média.");
            }

        } finally {
            System.out.println("\nPrograma encerrado.");
            scanner.close();
        }
    }
}
