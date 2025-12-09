import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class StreamCheckerTest {

    private boolean[] runQueries(StreamChecker checker, char[] queries) {
        boolean[] output = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            output[i] = checker.query(queries[i]);
        }
        return output;
    }

    @Test
    public void testWordsWithDifferentLengths() {
        StreamChecker checker = new StreamChecker(new String[] {"a", "abcdefg", "mnopqr"});
        char[] queries = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'm', 'n', 'o', 'p', 'q', 'r'};
        boolean[] expected = new boolean[] {true, false, false, false, false, false, true, false, false, false, false, false, true};

        assertArrayEquals(expected, runQueries(checker, queries));
    }

    @Test
    public void testSharedPrefixes() {
        StreamChecker checker = new StreamChecker(new String[] {"xy", "xyz"});
        char[] queries = new char[] {'x', 'y', 'z', 'a'};
        boolean[] expected = new boolean[] {false, true, true, false};

        assertArrayEquals(expected, runQueries(checker, queries));
    }

    @Test
    public void testHelloWorldDictionary() {
        StreamChecker checker = new StreamChecker(new String[] {"hello", "world"});
        char[] queries = new char[] {'h', 'e', 'l', 'l', 'o'};
        boolean[] expected = new boolean[] {false, false, false, false, true};

        assertArrayEquals(expected, runQueries(checker, queries));
    }

    @Test
    public void testOverlappingSuffixes() {
        StreamChecker checker = new StreamChecker(new String[] {"aa", "aaa"});
        char[] queries = new char[] {'a', 'a', 'a', 'b', 'a'};
        boolean[] expected = new boolean[] {false, true, true, false, false};

        assertArrayEquals(expected, runQueries(checker, queries));
    }

    @Test
    public void testSingleCharacterWords() {
        StreamChecker checker = new StreamChecker(new String[] {"a", "b", "c"});
        char[] queries = new char[] {'a', 'b', 'c', 'd', 'e', 'f'};
        boolean[] expected = new boolean[] {true, true, true, false, false, false};

        assertArrayEquals(expected, runQueries(checker, queries));
    }
}
