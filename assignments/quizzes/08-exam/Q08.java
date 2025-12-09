public class Q08 {
    public static void main(String[] args) {
        int k=0;
        try {
            int i = 5/k;
            System.out.print(i);
        } catch (ArithmeticException e) {
            System.out.print("1");
        } catch (RuntimeException e) {
            System.out.print("2");
            return;
        } catch (Exception e) {
            System.out.print("3");
        } finally {
            System.out.print("4");
        }
        System.out.print("5");
    } 
}
