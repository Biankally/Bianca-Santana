import java.util.Scanner;

public class SensorMonitorApp {
    public static void menu() {
        System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
        System.out.print("\n");
        System.out.println("1. Informar Temperatura");
        System.out.println("2. Consultar Média de Sensor");
        System.out.println("5. Sair");
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(System.in);
            SensorMonitor monitor = new SensorMonitor();
            
            System.out.println("=== Monitor de Sensores ===");
            System.out.println("Digite as leituras no formato: SENSOR_ID;TEMPERATURA");
            System.out.println("Digite 'FIM' para encerrar a coleta de leituras");
            System.out.println();
            
            // Coleta de leituras
            while (true) {
                System.out.print("Leitura: ");
                String line = input.nextLine().trim();
                
                if (line.equalsIgnoreCase("FIM")) {
                    break;
                }
                
                try {
                    monitor.addReading(line);
                    System.out.println("Leitura registrada com sucesso!");
                } catch (InvalidReadingException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
            
            // Exibir estatísticas
            System.out.println("\n=== Estatísticas ===");
            System.out.println("Leituras válidas: " + monitor.getValidReadings());
            System.out.println("Leituras inválidas: " + monitor.getInvalidReadings());
            
            // Consulta de médias
            System.out.println("\n=== Consulta de Médias ===");
            while (true) {
                System.out.print("Digite o ID do sensor para consultar a média (ou 'SAIR' para encerrar): ");
                String inputStr = input.nextLine().trim();
                
                if (inputStr.equalsIgnoreCase("SAIR")) {
                    break;
                }
                
                try {
                    int sensorId = Integer.parseInt(inputStr);
                    double average = monitor.averageFor(sensorId);
                    System.out.printf("Temperatura média do sensor %d: %.2f°C\n", sensorId, average);
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, digite um ID de sensor válido (número inteiro)");
                } catch (SensorNotFoundException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
            
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
            System.out.println("Programa encerrado.");
        }
    }
}