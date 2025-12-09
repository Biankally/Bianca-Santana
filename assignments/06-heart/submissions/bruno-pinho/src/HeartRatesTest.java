import java.util.Scanner;

/**
 * Aplicativo para solicitar informações do usuário, instanciar um objeto
 * HeartRates e exibir os resultados dos cálculos de frequência cardíaca.
 */
public class HeartRatesTest {

    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner input = new Scanner(System.in);

        // Solicita e lê as informações do usuário
        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.next();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        // Fecha o scanner para evitar vazamento de recursos
        input.close();

        // Instancia um objeto HeartRates com os dados fornecidos
        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        // Exibe as informações e os resultados calculados
        System.out.println("\n--- Informações do Paciente ---");
        System.out.printf("Nome: %s %s\n", person.getFirstName(), person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d\n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.printf("Idade: %d anos\n", person.calculateAge());
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", person.calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca alvo: %s\n", person.calculateTargetHeartRate());
    }
}