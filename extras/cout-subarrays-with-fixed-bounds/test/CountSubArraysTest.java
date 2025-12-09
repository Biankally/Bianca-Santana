import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountSubArraysTest {

    @Test
    void countSubarrays_mixedValues_singleValidWindow() {
        assertCount(1, new int[]{2, 1, 4, 3, 2}, 2, 3);
    }

    @Test
    void countSubarrays_palindromeArray_multipleValidWindows() {
        assertCount(5, new int[]{1, 2, 3, 2, 1}, 1, 3);
    }

    @Test
    void countSubarrays_allValuesEqual_exactBounds() {
        assertCount(6, new int[]{4, 4, 4}, 4, 4);
    }

    @Test
    void countSubarrays_allValuesEqual_outsideBounds() {
        assertCount(0, new int[]{2, 2, 2}, 4, 4);
    }

    @Test
    void countSubarrays_exampleFromProblemStatement_twoValidSubarrays() {
        assertCount(2, new int[]{1, 3, 5, 2, 7, 5}, 1, 5);
    }

    @Test
    void countSubarrays_entireArrayIsValid_singleWindow() {
        assertCount(1, new int[]{1, 5}, 1, 5);
    }

    @Test
    void countSubarrays_allElementsWithinBounds_manyOverlappingWindows() {
        assertCount(55, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1, 1);
    }

    @Test
    void countSubarrays_boundsNotReachable_zeroValidSubarrays() {
        assertCount(0, new int[]{1, 2, 3, 4}, 2, 5);
    }

    @Test
    void countSubarrays_alternatingBounds_denseWindows() {
        assertCount(15, new int[]{1, 3, 1, 3, 1, 3}, 1, 3);
    }

    private void assertCount(long expected, int[] nums, int minK, int maxK) {
        long actual = CountSubArrays.countSubarrays(nums, minK, maxK);
        assertEquals(expected, actual, "Unexpected count for " + describeCase(nums, minK, maxK));
    }

    private String describeCase(int[] nums, int minK, int maxK) {
        StringBuilder builder = new StringBuilder();
        builder.append("nums=");
        builder.append('[');
        for (int i = 0; i < nums.length; i++) {
            builder.append(nums[i]);
            if (i < nums.length - 1) {
                builder.append(',');
                builder.append(' ');
            }
        }
        builder.append("], minK=").append(minK).append(", maxK=").append(maxK);
        return builder.toString();
    }
}
