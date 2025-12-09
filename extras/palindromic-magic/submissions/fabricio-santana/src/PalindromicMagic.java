import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class PalindromicMagic {
    public static void main(String[] args){

        try(Scanner input = new Scanner(System.in)){
            String A = input.nextLine();
            String B = input.nextLine();

            Set<String> a = getPalindromeSubStrings(A);
            System.out.println(a.toString());

            Set<String> b = getPalindromeSubStrings(B);
            System.out.println(b.toString());

            Set<String> c = concatPalindromeSubstrings(a, b);
            System.out.println(c.toString());

            System.out.println(c.size());
        }
    }

    private static Set<String> getPalindromeSubStrings(String text){
        
        Set<String> subStrings = new HashSet<>();

        for (int i = 0; i <= text.length(); i++)
            for (int j = i + 1; j <= text.length(); j++) 
                    if (isPalindrome(text.substring(i , j)))
                        subStrings.add(text.substring(i , j));
        
        return subStrings;
    }

    private static Set<String> concatPalindromeSubstrings(Set<String> a, Set<String> b){

        Set<String> result = new HashSet<>();

        for (String s1 : a)
            for (String s2 : b)
                result.add(s1.concat(s2));

        return result;
    }

    private static boolean isPalindrome(String text){
        
        int left = 0, right = text.toLowerCase().length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
