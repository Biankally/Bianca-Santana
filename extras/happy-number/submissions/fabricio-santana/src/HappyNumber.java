import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) { 
        System.out.println(isHappyNumber(1));
        System.out.println(isHappyNumber(2));
        System.out.println(isHappyNumber(3));
        System.out.println(isHappyNumber(4));
        System.out.println(isHappyNumber(5));
        System.out.println(isHappyNumber(7));
        System.out.println(isHappyNumber(19));
    }
    
    public static boolean isHappyNumber(int n){
        return isHappyNumber(n, new HashSet<>());
    }

    public static boolean isHappyNumber(int n, Set<Integer> seen){     
        if (n <= 0) return false;
        if (n == 1) return true;
        if (!seen.add(n)) return false;

        int sumOfSquares = 0;

        while(n > 0) {
            int digit = n % 10;
            n = n / 10;
            sumOfSquares += (digit * digit);
        }
        return isHappyNumber(sumOfSquares, seen);
    }
}
