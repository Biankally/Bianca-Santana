import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HappyNumberTest {

    @Test
    void happyNumbersReturnTrue() {
        int[] happyNumbers = {1, 7, 10, 19, 68, 82, 100};
        for (int n : happyNumbers) {
            assertTrue(HappyNumber.isHappyNumber(n), n + " should be a happy number.");
        }
    }

    @Test
    void unhappyNumbersReturnFalse() {
        int[] unhappyNumbers = {2, 3, 4, 11, 20, 21};
        for (int n : unhappyNumbers) {
            assertFalse(HappyNumber.isHappyNumber(n), n + " should not be a happy number.");
        }
    }

    @Test
    void repeatedCallsDoNotShareStateAcrossInputs() {
        assertTrue(HappyNumber.isHappyNumber(19));
        assertTrue(HappyNumber.isHappyNumber(82)); // chain intersects numbers seen when evaluating 19
        assertTrue(HappyNumber.isHappyNumber(7));
    }

    @Test
    void repeatedCallsWithSameInputRemainConsistent() {
        assertTrue(HappyNumber.isHappyNumber(19));
        assertTrue(HappyNumber.isHappyNumber(19));
    }

    @Test
    void handlesBoundaryValues() {
        assertTrue(HappyNumber.isHappyNumber(1), "Lower bound must be happy.");
        assertFalse(HappyNumber.isHappyNumber(Integer.MAX_VALUE),
                "Upper bound should terminate and is not happy.");
    }
}
