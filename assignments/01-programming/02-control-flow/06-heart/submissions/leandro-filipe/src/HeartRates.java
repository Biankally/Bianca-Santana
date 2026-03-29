import java.util.Scanner;

public class HeartRates{

    // atributos
   private String firstName;
   private String lastName;
   
   private int dayOfBirth; 
   private int monthOfBirth;
   private int yearOfBirth;

   // construtor
   public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth){
    this.firstName = firstName;
    this.lastName = lastName;
    this.dayOfBirth = dayOfBirth;
    this.monthOfBirth = monthOfBirth;
    this.yearOfBirth = yearOfBirth;
   }


   // metodos set e get
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    // metodos de calculo

    int currentYear = 2026;
    int age;

    // calculo idade
    public int calculateAge(int currentYear){

        age = currentYear - yearOfBirth;
        return age;
        
    }

    int freqMax;
    // caculo freq cardiaca maxima
    public calculateMaxHeatRate(){

        freqMax = 220 - age;
        return freqMax;
    }

    int freqAlvoMin;
    int freqAlvoMax;
    // faixa de freq cardiaca alvo (minimo e maximo)
    public String calculateTargetHeartRate(){

        freqAlvoMin = freqMax * 0.5;
        freqAlvoMax = freqMax * 0.85;

        return freqAlvoMin + " - " + freqAlvoMax + " bpm";
    }
    
    public static void main(String[] args){


        System.out.print("Digite seu primeiro nome: ");
        String nome = input.next();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = input.next();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dia = input.nextInt();
        int mes = input.nextInt();
        int ano = input.nextInt();

        HeartRates p1HeartRates = new HeartRates(nome, sobrenome, dia, mes, ano);

        p1HeartRates.calculateAge(ano);
        p1HeartRates.calculateMaxHeatRate();
        p1HeartRates.calculateTargetHeartRate();
        


        // exibindo as informações

        System.out.print("Nome: " + nome);
        System.out.println("Idade: " + p1HeartRates.calculateAge(2026) + " anos");
        System.out.println("Frequência cardíaca máxima: " + p1HeartRates.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + p1HeartRates.calculateTargetHeartRate());
        
        
        
        input.close();
    }
   
}


