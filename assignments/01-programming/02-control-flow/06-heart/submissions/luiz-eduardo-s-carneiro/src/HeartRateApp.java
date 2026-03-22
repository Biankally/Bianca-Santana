import java.util.Scanner;

public class HeartRateApp{
    
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            HeartRate heartRate = new HeartRate();

            int currentYear = 2026;

            System.out.printf("Digite o seu primeiro nome: ");
            String firstName = scanner.next();

            System.out.printf("Digite o seu sobrenome: ");
            String lastName = scanner.next();

            System.out.printf("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int dayOfBirth = scanner.nextInt();
            int monthOfBirth = scanner.nextInt();
            int yearOfBirth = scanner.nextInt();

            heartRate.setFirstName(firstName);
            heartRate.setLastName(lastName);
            heartRate.setDayOfBirth(dayOfBirth);
            heartRate.setMonthOfBirth(monthOfBirth);
            heartRate.setYearOfBirth(yearOfBirth);

            double max = heartRate.calculateMaxHeartRate(currentYear);
            double[] alvo = heartRate.calculateTargetHeartRate(currentYear);

            System.out.printf("Nome: %s %s\n", heartRate.getFirstName(), heartRate.getLastName());
            System.out.printf("Data de nascimento: %d/%d/%d\n", heartRate.getDayOfBirth(), 
                    heartRate.getMonthOfBirth(), heartRate.getYearOfBirth());
            System.out.printf("Idade: %d\n", heartRate.calculateAge(currentYear));
            System.out.printf("Frequência cardíaca máxima: %.2f bpm\n", max);
            System.out.printf("Faixa de frequência cardíaca alvo: %.2f bpm - %.2f bpm\n", alvo[0], alvo[1]);
        }
    }
}