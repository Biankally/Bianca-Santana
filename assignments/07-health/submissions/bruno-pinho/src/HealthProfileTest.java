import java.util.Scanner;
import java.util.Locale;

/**
 * Aplicativo para coletar dados do paciente, instanciar um objeto HealthProfile
 * e exibir as informações de saúde calculadas, incluindo a tabela de valores de IMC.
 */
public class HealthProfileTest {
    public static void main(String[] args) {
        // Define o Locale para US para garantir que o ponto seja usado como separador decimal
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("--- Cadastro de Perfil de Saúde ---");
        
        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = input.next().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = input.nextDouble();
        
        input.close();

        // Cria uma instância de HealthProfile com os dados fornecidos
        HealthProfile patient = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        // Exibe o relatório completo
        System.out.println("\n--- Relatório de Saúde ---");
        System.out.printf("Nome: %s %s\n", patient.getFirstName(), patient.getLastName());
        System.out.printf("Gênero: %s\n", (patient.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d\n", patient.getDayOfBirth(), patient.getMonthOfBirth(), patient.getYearOfBirth());
        System.out.printf("Idade: %d anos\n", patient.calculateAge());
        System.out.printf("Altura: %.1f polegadas\n", patient.getHeightInInches());
        System.out.printf("Peso: %.1f libras\n", patient.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", patient.calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", patient.calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca alvo: %s\n", patient.calculateTargetHeartRate());
        
        // Exibe a tabela de referência do IMC
        displayBmiTable();
    }

    /**
     * Método auxiliar para exibir a tabela de classificação do IMC.
     */
    public static void displayBmiTable() {
        System.out.println("\n--- Tabela de Referência do BMI ---");
        System.out.println("BMI              | Classificação");
        System.out.println("-------------------------------------");
        System.out.println("Menos de 18.5    | Abaixo do peso");
        System.out.println("18.5 – 24.9      | Peso normal");
        System.out.println("25.0 – 29.9      | Sobrepeso");
        System.out.println("30.0 ou mais     | Obesidade");
        System.out.println("-------------------------------------");
    }
}