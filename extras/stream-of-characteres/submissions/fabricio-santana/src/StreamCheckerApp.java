import java.util.Arrays;

public class StreamCheckerApp {
    public static void main(String[] args) {

        String[] words = {"a", "aa"};
        char[] streamOfCharacters  = {'a', 'a', 'a', 'b'};
        
        StreamChecker sc = new StreamChecker(words);

        System.out.println(Arrays.toString(runQueries(sc, streamOfCharacters)));

        String[] words2 = {"no", "yes"};
        char[] streamOfCharacters2  = {'y', 'e', 's', 'n', 'o'};
        
        StreamChecker sc2 = new StreamChecker(words2);

        System.out.println(Arrays.toString(runQueries(sc2, streamOfCharacters2)));
    }

    private static boolean[] runQueries(StreamChecker checker, char[] queries) {
        boolean[] output = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            output[i] = checker.query(queries[i]);
        }
        return output;
    }
}
