import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {

        Scanner scanner_entrada = new Scanner(System.in);
        SensorMonitor monitor = new SensorMonitor();

        int leiturasValidas = 0;
        int leiturasIgnoradas = 0;

        System.out.println("Digite as leituras do sensor (formato: id;temperatura) ou 'FIM' para sair.");

        while(true){
            String linha = scanner_entrada.nextLine();

            if(linha.equalsIgnoreCase("FIM")){
                break;
            }

            if (linha.trim().isEmpty()) {
                continue;
            }

            try {
                monitor.addReading(linha);
                leiturasValidas++;
            } catch (InvalidReadingException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Por favor, tente novamente.");
                leiturasIgnoradas++;
            }
        }

        System.out.println("_____________Relatório Final______________");
        System.out.printf("Total de leituras válidas: %d%n", leiturasValidas); 
        System.out.printf("Total de leituras ignoradas por erro: %d%n", leiturasIgnoradas); 
        System.out.printf("Temperatura média registrada: %.2f°C%n", monitor.getAverageTemperature());

        scanner_entrada.close();
        System.out.println("Programa encerrado.");
    }
}
