public class Q03 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a++ + ++b;
        System.out.println(c);
        boolean check = (a += b) > c && (c-- > 3);
        System.out.println(a + ":" + b + ":" + c + ":" + check);
    }
}
