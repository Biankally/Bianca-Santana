import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleTest {

    @Test
    void canFinish_withoutPrerequisites_returnsTrue() {
        assertTrue(CourseSchedule.canFinish(3, new int[0][0]),
                "Without prerequisites every course should be completable.");
    }

    @Test
    void canFinish_linearDependencies_returnsTrue() {
        assertTrue(CourseSchedule.canFinish(4, new int[][]{
                {1, 0},
                {2, 1},
                {3, 2}
        }), "A simple chain is acyclic.");
    }

    @Test
    void canFinish_simpleCycle_returnsFalse() {
        assertFalse(CourseSchedule.canFinish(2, new int[][]{
                {0, 1},
                {1, 0}
        }), "Two courses that depend on each other form a cycle.");
    }

    @Test
    void canFinish_selfDependency_returnsFalse() {
        assertFalse(CourseSchedule.canFinish(1, new int[][]{
                {0, 0}
        }), "A course that depends on itself cannot be completed.");
    }

    @Test
    void canFinish_cycleInDisconnectedComponent_returnsFalse() {
        assertFalse(CourseSchedule.canFinish(5, new int[][]{
                {1, 0},
                {2, 1},
                {3, 4},
                {4, 3}
        }), "A cycle in any component prevents completion of all courses.");
    }

    @Test
    void canFinish_multipleBranchesWithoutCycles_returnsTrue() {
        assertTrue(CourseSchedule.canFinish(6, new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {4, 1},
                {5, 2}
        }), "Multiple branches without a cycle should be completable.");
    }

    @Test
    void canFinish_requestCase_chainLengthThree_returnsTrue() {
        assertTrue(CourseSchedule.canFinish(3, new int[][]{
                {1, 0},
                {2, 1}
        }));
    }

    @Test
    void canFinish_requestCase_chainWithBackEdge_returnsFalse() {
        assertFalse(CourseSchedule.canFinish(3, new int[][]{
                {1, 0},
                {2, 1},
                {1, 2}
        }));
    }

    @Test
    void canFinish_requestCase_disconnectedAcyclic_returnsTrue() {
        assertTrue(CourseSchedule.canFinish(5, new int[][]{
                {1, 0},
                {2, 1},
                {4, 3}
        }));
    }

    @Test
    void canFinish_requestCase_twoCourseCycle_returnsFalse() {
        assertFalse(CourseSchedule.canFinish(2, new int[][]{
                {1, 0},
                {0, 1}
        }));
    }

    @Test
    void canFinish_requestCase_longChain_returnsTrue() {
        assertTrue(CourseSchedule.canFinish(5, new int[][]{
                {1, 0},
                {2, 1},
                {3, 2},
                {4, 3}
        }));
    }

    @Test
    void canFinish_requestCase_chainClosingCycle_returnsFalse() {
        assertFalse(CourseSchedule.canFinish(5, new int[][]{
                {1, 0},
                {2, 1},
                {3, 2},
                {4, 3},
                {0, 4}
        }));
    }

    @Test
    void canFinish_requestCase_largeCycle_returnsFalse() {
        assertFalse(CourseSchedule.canFinish(41, new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 7},
                {7, 8},
                {8, 9},
                {9, 10},
                {10, 11},
                {11, 12},
                {12, 13},
                {13, 14},
                {14, 15},
                {15, 16},
                {16, 17},
                {17, 18},
                {18, 19},
                {19, 20},
                {20, 21},
                {21, 22},
                {22, 23},
                {23, 24},
                {24, 25},
                {25, 26},
                {26, 27},
                {27, 28},
                {28, 29},
                {29, 30},
                {30, 31},
                {31, 32},
                {32, 33},
                {33, 34},
                {34, 35},
                {35, 36},
                {36, 37},
                {37, 38},
                {38, 39},
                {39, 40},
                {40, 0}
        }));
    }

    @Test
    void canFinish_requestCase_sharedPrerequisites_returnsTrue() {
        assertTrue(CourseSchedule.canFinish(5, new int[][]{
                {2, 0},
                {2, 1},
                {3, 2},
                {4, 2}
        }));
    }
}
