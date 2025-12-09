import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SetMatrixZeroesTest {

    @Test
    public void setMatrixZeroes_singleZero_setsEntireRowAndColumn() {
        int[][] matrix = {
                {5, 1, 9},
                {3, 0, 7},
                {8, 6, 2}
        };

        int[][] expected = {
                {5, 0, 9},
                {0, 0, 0},
                {8, 0, 2}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_multipleZeros_combinesAllRowsAndColumns() {
        int[][] matrix = {
                {1, 2, 0, 4},
                {5, 6, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] expected = {
                {0, 0, 0, 0},
                {0, 6, 0, 8},
                {0, 0, 0, 0},
                {0, 14, 0, 16}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_noZeros_keepsMatrixIntact() {
        int[][] matrix = {
                {9, 8},
                {7, 6}
        };

        int[][] expected = copyMatrix(matrix);

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_zeroInFirstRowOrColumn_hitsBoundaryRows() {
        int[][] matrix = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 0, 9}
        };

        int[][] expected = {
                {0, 0, 0},
                {0, 0, 6},
                {0, 0, 0}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_oneZeroInMiddle() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 9}
        };

        int[][] expected = {
                {1, 0, 3},
                {4, 0, 6},
                {0, 0, 0}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_noZeros() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {8, 9, 4, 6}
        };

        int[][] expected = copyMatrix(matrix);

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_multipleZerosLargeMatrix() {
        int[][] matrix = {
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        int[][] expected = {
                {0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_centerZeroInSquare() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_zeroInLastColumnAndMiddle() {
        int[][] matrix = {
                {3, 5, 2, 0},
                {1, 0, 4, 6},
                {7, 3, 2, 4}
        };

        int[][] expected = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {7, 0, 2, 0}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_largeMatrixWithManyZeros() {
        int[][] matrix = {
                {257, 396, 754, 665, 697, 229, 381, 0, 788, 604, 25, 636, 20, 587, 951, 56, 935, 593, 98, 993},
                {636, 985, 720, 595, 577, 688, 504, 668, 656, 477, 994, 373, 902, 77, 752, 329, 273, 164, 268, 589},
                {846, 810, 647, 623, 0, 53, 892, 281, 414, 699, 448, 834, 243, 703, 461, 0, 522, 20, 118, 723},
                {676, 477, 149, 362, 530, 691, 481, 138, 989, 80, 457, 651, 589, 47, 832, 755, 142, 356, 896, 0},
                {598, 335, 204, 259, 156, 83, 323, 918, 138, 893, 642, 282, 0, 634, 928, 186, 362, 726, 609, 825},
                {0, 0, 505, 363, 408, 290, 312, 3, 985, 949, 422, 457, 959, 30, 542, 897, 403, 55, 76, 328},
                {557, 943, 439, 673, 49, 10, 512, 533, 233, 152, 848, 662, 882, 810, 935, 603, 0, 229, 402, 555},
                {449, 312, 732, 866, 671, 589, 687, 132, 249, 647, 635, 744, 802, 0, 546, 439, 122, 829, 110, 954},
                {726, 437, 409, 976, 53, 559, 1, 857, 0, 613, 675, 381, 108, 234, 179, 274, 637, 221, 398, 554},
                {0, 240, 270, 379, 801, 465, 0, 175, 895, 745, 526, 353, 309, 26, 504, 995, 76, 705, 765, 773},
                {721, 981, 263, 957, 319, 553, 459, 693, 853, 948, 451, 964, 549, 69, 100, 189, 682, 287, 842, 8},
                {749, 875, 564, 497, 701, 205, 960, 99, 663, 159, 570, 49, 450, 747, 718, 913, 425, 436, 532, 368},
                {917, 556, 862, 594, 886, 854, 115, 524, 308, 818, 753, 483, 802, 420, 7, 876, 636, 575, 345, 985},
                {871, 955, 159, 242, 993, 930, 899, 559, 57, 694, 777, 204, 575, 653, 173, 4, 846, 347, 717, 91},
                {426, 499, 28, 786, 909, 377, 727, 139, 0, 270, 448, 415, 816, 741, 831, 800, 735, 662, 894, 400}
        };

        int[][] expected = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 720, 595, 0, 688, 0, 0, 0, 477, 994, 373, 0, 0, 752, 0, 0, 164, 268, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 263, 957, 0, 553, 0, 0, 0, 948, 451, 964, 0, 0, 100, 0, 0, 287, 842, 0},
                {0, 0, 564, 497, 0, 205, 0, 0, 0, 159, 570, 49, 0, 0, 718, 0, 0, 436, 532, 0},
                {0, 0, 862, 594, 0, 854, 0, 0, 0, 818, 753, 483, 0, 0, 7, 0, 0, 575, 345, 0},
                {0, 0, 159, 242, 0, 930, 0, 0, 0, 694, 777, 204, 0, 0, 173, 0, 0, 347, 717, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    private static void assertMatrixEquals(int[][] expected, int[][] actual) {
        for (int row = 0; row < expected.length; row++) {
            assertArrayEquals(expected[row], actual[row], "Row " + row + " mismatch");
        }
    }

    private static int[][] copyMatrix(int[][] source) {
        int[][] copy = new int[source.length][];
        for (int row = 0; row < source.length; row++) {
            copy[row] = Arrays.copyOf(source[row], source[row].length);
        }
        return copy;
    }
}
