import java.time.LocalDate;
import java.util.Scanner;

public class HeartRates {
    // 2. Atributos privados
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // 3. Construtor
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // 4. Métodos de acesso (Getters e Setters)
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    // 5. Métodos de cálculo
    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        int currentYear = LocalDate.now().getYear();
        int age = calculateAge(currentYear);
        return 220 - age;
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    // 6. Programa principal (main)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.next();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        // Instanciando o objeto
        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%04d\n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        
        // Obtendo o ano atual dinamicamente para passar como argumento
        int currentYear = LocalDate.now().getYear();
        System.out.println("Idade: " + person.calculateAge(currentYear) + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());

        input.close();
    }
}