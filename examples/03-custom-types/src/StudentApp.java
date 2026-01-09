import java.util.Scanner;

public class StudentApp {
    public static void main (String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the student's name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter the student's age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter the student's course: ");
            String course = scanner.nextLine();
            
            Student student = new Student(name, age, course);
            
            System.out.printf("Hello, %s!\nYou're %s years old and are enrolled in %s course.\n",
                    student.getName(),
                    student.getAge(),
                    student.getCourse());
        }
    }
}