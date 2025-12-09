import java.util.Scanner;

class HealthProfile {
    private String firstName, lastName;
    private char gender;
    private int dayOfBirth, monthOfBirth, yearOfBirth;
    private double heightInInches, weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int day, int month, int year, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
        this.heightInInches = height;
        this.weightInPounds = weight;
    }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(int age) {
        return 220 - age;
    }

    public double[] calculateTargetHeartRate(int maxRate) {
        return new double[]{maxRate * 0.5, maxRate * 0.85};
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public String getGenderDescription() {
        return (gender == 'M' || gender == 'm') ? "Masculino" : "Feminino";
    }

    public void displayInfo() {
        System.out.println("Nome: " + firstName + " " + lastName);
        System.out.println("Gênero: " + getGenderDescription());
        System.out.println("Data de nascimento: " + dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth);
        System.out.println("Altura: " + heightInInches + " polegadas");
        System.out.println("Peso: " + weightInPounds + " libras");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu primeiro nome: ");
        String first = sc.next();
        System.out.print("Digite seu sobrenome: ");
        String last = sc.next();
        System.out.print("Digite seu gênero (M/F): ");
        char gender = sc.next().charAt(0);
        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = sc.nextInt(), month = sc.nextInt(), year = sc.nextInt();
        System.out.print("Digite sua altura em polegadas: ");
        double height = sc.nextDouble();
        System.out.print("Digite seu peso em libras: ");
        double weight = sc.nextDouble();

        HealthProfile hp = new HealthProfile(first, last, gender, day, month, year, height, weight);
        int age = hp.calculateAge(2025);
        int maxRate = hp.calculateMaxHeartRate(age);
        double[] target = hp.calculateTargetHeartRate(maxRate);
        double bmi = hp.calculateBMI();

        System.out.println();
        hp.displayInfo();
        System.out.println("Idade: " + age + " anos");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", bmi);
        System.out.println("Frequência cardíaca máxima: " + maxRate + " bpm");
        System.out.printf("Faixa de frequência cardíaca alvo: %.0f bpm - %.0f bpm%n", target[0], target[1]);
        System.out.println();
        System.out.println("BMI\t\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");
        sc.close();
    }
}
