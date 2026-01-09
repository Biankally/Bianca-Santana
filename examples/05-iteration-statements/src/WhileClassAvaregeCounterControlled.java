public class ClassAvaregeCounterControlled {

    public static void main(String[] args) throws Exception {
        int total = 0;
        int gradeCounter = 1;

        java.util.Scanner input = new java.util.Scanner(System.in);
        while (gradeCounter <= 10) {

            System.out.print("Enter grade: ");
            int grade = input.nextInt();
            total = total + grade;
            gradeCounter = gradeCounter + 1;
        }
       
        double average = (double) total / 10;
        System.out.printf("%nTotal of the %d grades entered is %d%n", 1010, total);
        System.out.printf("Class average is %.2f%n", average);
    }

}
