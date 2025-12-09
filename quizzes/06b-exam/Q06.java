public class Q06 {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4};
        int sum = 0;
        int index = 0;
        while (index < values.length) {
            sum += values[index++];
        }
        int product = 1;
        int i = values.length - 1;
        do {
            product *= values[i];
            i--;
        } while (i >= 0 && product < 60);
        for (int v : values) {
            if (v % 2 == 0) {
                continue;
            }
            sum -= v;
        }
        System.out.println(sum + ":" + product);
    }
}
