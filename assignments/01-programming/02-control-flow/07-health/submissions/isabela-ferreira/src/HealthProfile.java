import java.util.Scanner;
import java.util.Calendar;

public class HealthProfile {
    // Atributos privados
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    // Construtor
    public HealthProfile(String firstName, String lastName, char gender,
                         int dayOfBirth, int monthOfBirth, int yearOfBirth,
                         double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // Getters e Setters (para todos os atributos)
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }

    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public double getHeightInInches() { return heightInInches; }
    public void setHeightInInches(double heightInInches) { this.heightInInches = heightInInches; }

    public double getWeightInPounds() { return weightInPounds; }
    public void setWeightInPounds(double weightInPounds) { this.weightInPounds = weightInPounds; }

    // Métodos de cálculo
    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(int currentYear) {
        int age = calculateAge(currentYear);
        return 220 - age;
    }

    public String calculateTargetHeartRate(int currentYear) {
        int max = calculateMaxHeartRate(currentYear);
        int targetMin = (int) (max * 0.5);
        int targetMax = (int) (max * 0.85);
        return targetMin + " bpm - " + targetMax + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }
}

// ====================== CLASSE DE TESTE (main) ======================
class HealthProfileTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Obtém ano corrente automaticamente
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Entrada de dados (exatamente como no enunciado)
        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.next();

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

        // Instancia o objeto
        HealthProfile profile = new HealthProfile(firstName, lastName, gender,
                day, month, year, height, weight);

        // Exibe informações
        String genderStr = (profile.getGender() == 'M') ? "Masculino" : "Feminino";

        System.out.println("\nNome: " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Gênero: " + genderStr);
        System.out.printf("Data de nascimento: %d/%02d/%d%n", 
                          profile.getDayOfBirth(), profile.getMonthOfBirth(), profile.getYearOfBirth());
        System.out.printf("Idade: %d anos%n", profile.calculateAge(currentYear));
        System.out.printf("Altura: %.0f polegadas%n", profile.getHeightInInches());
        System.out.printf("Peso: %.0f libras%n", profile.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", profile.calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", 
                          profile.calculateMaxHeartRate(currentYear));
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", 
                          profile.calculateTargetHeartRate(currentYear));

        // Tabela de referência do BMI
        System.out.println("\nTabela de referência do BMI:");
        System.out.println("BMI                Classificação");
        System.out.println("Menos de 18.5      Abaixo do peso");
        System.out.println("18.5 – 24.9        Peso normal");
        System.out.println("25.0 – 29.9        Sobrepeso");
        System.out.println("30.0 ou mais       Obesidade");

        input.close();
    }
}