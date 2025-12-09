import java.time.LocalDate;
import java.time.Period;

/**
 * A classe HeartRates armazena informações sobre uma pessoa, incluindo nome,
 * sobrenome e data de nascimento, e calcula a idade, a frequência cardíaca
 * máxima e a faixa de frequência cardíaca alvo.
 */
public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    /**
     * Construtor para inicializar os dados da pessoa.
     *
     * @param firstName    O primeiro nome da pessoa.
     * @param lastName     O sobrenome da pessoa.
     * @param dayOfBirth   O dia de nascimento.
     * @param monthOfBirth O mês de nascimento.
     * @param yearOfBirth  O ano de nascimento.
     */
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // Métodos set e get para firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    // Métodos set e get para lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    // Métodos set e get para dayOfBirth
    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    // Métodos set e get para monthOfBirth
    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    // Métodos set e get para yearOfBirth
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Calcula e retorna a idade da pessoa em anos.
     * O cálculo é feito com base na data atual.
     *
     * @return A idade da pessoa em anos.
     */
    public int calculateAge() {
        LocalDate birthDate = LocalDate.of(this.yearOfBirth, this.monthOfBirth, this.dayOfBirth);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    /**
     * Calcula e retorna a frequência cardíaca máxima da pessoa.
     * Fórmula: 220 - idade.
     *
     * @return A frequência cardíaca máxima em batimentos por minuto (bpm).
     */
    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    /**
     * Calcula e retorna a faixa de frequência cardíaca alvo da pessoa (50% - 85%).
     *
     * @return Uma String formatada com a faixa de frequência cardíaca alvo.
     */
    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return String.format("%d bpm - %d bpm", minTarget, maxTarget);
    }
}