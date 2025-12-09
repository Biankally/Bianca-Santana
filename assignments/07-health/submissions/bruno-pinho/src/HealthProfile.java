import java.time.LocalDate;
import java.time.Period;

/**
 * A classe HealthProfile representa um registro de saúde de um paciente.
 * Ela armazena dados básicos e calcula métricas de saúde como idade,
 * frequência cardíaca e Índice de Massa Corporal (IMC).
 */
public class HealthProfile {
    // Atributos privados
    private String firstName;
    private String lastName;
    private char gender; // 'M' para masculino, 'F' para feminino
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    /**
     * Construtor para inicializar um novo perfil de saúde.
     */
    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth,
                         int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // Métodos de Acesso (Getters e Setters)
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

    // Métodos de Cálculo
    /**
     * Calcula e retorna a idade do paciente em anos, com base na data atual.
     * @return A idade em anos.
     */
    public int calculateAge() {
        LocalDate birthDate = LocalDate.of(this.yearOfBirth, this.monthOfBirth, this.dayOfBirth);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    /**
     * Calcula e retorna a frequência cardíaca máxima do paciente.
     * Fórmula: 220 - idade.
     * @return A frequência cardíaca máxima em batimentos por minuto (bpm).
     */
    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    /**
     * Calcula e retorna a faixa de frequência cardíaca alvo (50% - 85% da máxima).
     * @return Uma String formatada com a faixa alvo.
     */
    public String calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        int minTarget = (int) (maxRate * 0.50);
        int maxTarget = (int) (maxRate * 0.85);
        return String.format("%d bpm - %d bpm", minTarget, maxTarget);
    }

    /**
     * Calcula e retorna o Índice de Massa Corporal (IMC) do paciente.
     * Fórmula: (peso_lbs * 703) / (altura_pol^2)
     * @return O valor do IMC.
     */
    public double calculateBMI() {
        if (getHeightInInches() <= 0) {
            return 0; // Evita divisão por zero
        }
        return (getWeightInPounds() * 703) / (getHeightInInches() * getHeightInInches());
    }
}