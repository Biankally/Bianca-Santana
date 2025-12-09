import java.util.Arrays;

public class Q01 {
    public static void main(String[] args){
        int[] numbers = {-1, 1, -2, 3, 0};
        
        System.out.println(M01(numbers));
        System.out.println(M02(numbers));
        
        int[] numbers2 = {-1, 1, -2, 3, 0};
        System.out.println(Arrays.toString(M03(numbers2)));
        System.out.println(Arrays.toString(M04(numbers2)));

        String[] names = {"Fabricio", "Yuri", "Alberto", "Lucas"};
        M05(names);
        System.out.println(Arrays.toString(names));
    }

    public static int M01(int[] i){
        int x = Integer.MAX_VALUE; // 2147483647
    
        for (int y : i) x = y < x ? y : x;

        return x;
    }

    public static int M02(int[] i){
        Arrays.sort(i);
        return i[0];
    }

    public static int[] M03(int[] i){
        int x = Integer.MIN_VALUE; // -2147483648
        int y = Integer.MAX_VALUE; // 2147483647
        for (int n : i) {
            if (n > x) {
                x = n;
            } else if (n < y) {
                y = n;
            }
        }
        return new int[]{y, x};
    }

    public static int[] M04(int[] i){
        Arrays.sort(i);
        return new int[]{i[0], i[i.length-1]};
    }

    public static void M05(String[] names){
        for (int i = 0; i < names.length/2; i++) {
            String temp = names[i];

            names[i] = names[names.length-1-i];
            names[names.length-1-i] = temp;
        }
    }
}
