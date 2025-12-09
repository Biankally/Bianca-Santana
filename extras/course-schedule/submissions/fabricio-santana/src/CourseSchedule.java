import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 2},
                {4, 3},
                {0, 4}
        };

        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        if (prerequisites != null) {
            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int dependency = prerequisite[1];
                adjacency.get(dependency).add(course);
                System.out.println(adjacency);
                inDegree[course]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) {
            if (inDegree[course] == 0) {
                queue.offer(course);
            }
        }

        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            for (int nextCourse : adjacency.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return completedCourses == numCourses;
    }
}
