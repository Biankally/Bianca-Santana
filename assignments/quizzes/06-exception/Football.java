public class Football {
    public static void main(String officials[]) {
        try {
            System.out.println('A');
            throw new RuntimeException("Out of bounds!");
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println('B');
            throw aioobe;
        } finally {
            System.out.println('C');
        }
    } 
}
