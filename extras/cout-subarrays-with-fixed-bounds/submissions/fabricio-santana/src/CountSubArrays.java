import java.util.Arrays;

public class CountSubArrays {
    public static void main(String[] args) {

        long result;

        result = listSubarrays(new int[] {2, 1, 4, 3, 2}, 2 ,3);
        System.out.println(result);

        result = countSubarrays(new int[] {2, 1, 4, 3, 2}, 2 ,3);
        System.out.println(result);
    }

    public static long listSubarrays(int[] nums, int minK, int maxK){
       
        System.out.printf("Input%n - num: %s%n - minK: %s%n - maxK: %s%n", Arrays.toString(nums), minK, maxK);

        long qtdSubarrays = 0;
        boolean isMinKPresent = false;
        boolean isMaxKPresent = false;
        boolean outOfBounds = false;

        System.out.print("Output:");

        for (int pointer = 0; pointer < nums.length; pointer++){
            for (int i = pointer; i < nums.length; i++){
                if (nums[i] == minK) isMinKPresent = true;
                if (nums[i] == maxK) isMaxKPresent = true;
                if (nums[i] < minK || nums[i] > maxK) outOfBounds = true;

                if (isMinKPresent && isMaxKPresent && !outOfBounds){
                    int[] temp = Arrays.copyOfRange(nums, pointer, i+1);
                    System.out.println(Arrays.toString(temp));
                    qtdSubarrays++;
                }
            }

            isMinKPresent = false;
            isMaxKPresent = false;
            outOfBounds = false;
        }
        return qtdSubarrays;
    }

    public static long countSubarrays(int[] nums, int minK, int maxK){

        int lastMinIndex = -1;
        int lastMaxIndex = -1;
        int firstValidIndex = -1;
        int qtdSubarrays = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] < minK || nums[i] > maxK) {
                lastMinIndex = -1;
                lastMaxIndex = -1;
                firstValidIndex = -1;
                continue;
            }

            if (firstValidIndex == -1) firstValidIndex = i;
            if (nums[i] == minK) lastMinIndex = i;
            if (nums[i] == maxK) lastMaxIndex = i;

            if (lastMinIndex != -1 && lastMaxIndex != -1)
                qtdSubarrays += 1 + (Math.min(lastMinIndex, lastMaxIndex) - firstValidIndex);
        }

        return qtdSubarrays;
    }
}
