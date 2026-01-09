
import java.util.Scanner;

public class CustomLetterGrades {
    public static void main(String[] args) {
        int total = 0;
        int gradeCounter = 0;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;

        try (Scanner input = new Scanner(System.in)) {
            System.out.printf("%s%n%s%n%s%n%s%n",
            "Enter the integer grades in the range 0-100.",
                        "\tType the end-of-file indicator to terminate input:",
                            "\t\tOn UNIX/Linux/Mac OS X type <Ctrl> d then press Enter",
                            "\t\tOn Windows type <Ctrl> z then press Enter");  

            while (input.hasNext()) {
                int grade = input.nextInt();
                total += grade;
                ++gradeCounter;
                switch (grade / 10) {
                    case 10, 9 -> ++aCount;
                    case 8 -> ++bCount;
                    case 7 -> ++cCount;
                    case 6 -> ++dCount;
                    default -> ++fCount;
                }
            }
        }

        System.out.println("\nGrade Report:");
        if (gradeCounter != 0) {
            double average = (double) total / gradeCounter;
            System.out.printf("Total of the %d grades entered is %d\n", gradeCounter, total);
            System.out.printf("Class average is %.2f\n", average);
            System.out.printf("%nNumber of students who received each grade:\n");
            System.out.printf("A: %d%n", aCount);
            System.out.printf("B: %d%n", bCount);
            System.out.printf("C: %d%n", cCount);
            System.out.printf("D: %d%n", dCount);
            System.out.printf("F: %d%n", fCount);
        } else {
            System.out.println("No grades were entered");
        }
    }
}
