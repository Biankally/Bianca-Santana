public class HeartRate{
    
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRate(){
    }

    public HeartRate(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;

        if(dayOfBirth > 0 && monthOfBirth > 0 && yearOfBirth > 0){
            this.dayOfBirth = dayOfBirth;
            this.monthOfBirth = monthOfBirth;
            this.yearOfBirth = yearOfBirth;
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

}