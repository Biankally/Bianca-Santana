

public class CustomStudentApp {
    public static void main(String[] args) throws Exception {
        
        CustomStudent student1 = new CustomStudent("Maria da Silva", 95.0);
        CustomStudent student2 = new CustomStudent("João da Silva", 70.0);

        System.out.printf("%s's letter grade is: %s%n", student1.getName(), student1.getLetterGrade());
        System.out.printf("%s's letter grade is: %s%n", student2.getName(), student2.getLetterGrade());
    }
}
