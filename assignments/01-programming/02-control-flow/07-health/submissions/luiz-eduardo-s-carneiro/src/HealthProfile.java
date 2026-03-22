public class HealthProfile{

    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private char gender;
    private double heighInInches;
    private double weightInPounds;

    public HealthProfile(){
    }

    public HealthProfile(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth, double weightInPounds, double heighInInches){
        this.firstName = firstName;
        this.lastName = lastName;

        if(dayOfBirth > 0 && monthOfBirth > 0 && yearOfBirth > 0){
            this.dayOfBirth = dayOfBirth;
            this.monthOfBirth = monthOfBirth;
            this.yearOfBirth = yearOfBirth;
        }

        if(heighInInches > 0 && weightInPounds > 0){
            this.heighInInches = heighInInches;
            this.weightInPounds = weightInPounds;
        }
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setDayOfBirth(int dayOfBirth){
        this.dayOfBirth = dayOfBirth;
    }

    public int getDayOfBirth(){
        return dayOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth){
        this.monthOfBirth = monthOfBirth;
    }

    public int getMonthOfBirth(){
        return monthOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth){
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth(){
        return yearOfBirth;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender == 'M' ? "Masculino" : (gender == 'F') ? "Feminino" : "Gênero inválido";
    }

    public void setWeightInPounds(double weightInPounds){
        this.weightInPounds = weightInPounds;
    }

    public double getWeightInPounds(){
        return weightInPounds;
    }

    public void setHeighInInches(double heighInInches){
        this.heighInInches = heighInInches;
    }

    public double getHeighInInches(){
        return heighInInches;
    }

    public int calculateAge(int currentYear){
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(int currentYear){
        return 220 - calculateAge(currentYear);
    }

    public double[] calculateTargetHeartRate(int currentYear){
        double minTarget = calculateMaxHeartRate(currentYear) * 0.55;
        double maxTarget = calculateMaxHeartRate(currentYear) * 0.85;

        return new double[]{minTarget, maxTarget};
    }

    public double calculateBMI(){
        return weightInPounds * 703 / Math.pow(heighInInches, 2);
    }
}