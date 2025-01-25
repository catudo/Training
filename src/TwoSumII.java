import java.util.Arrays;

public class TwoSumII {

    /*
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if(sum == target && i != j ) {
                   return new int[]{i+1, j+1};
                }
            }
        }
        return null;
    } */

    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0, j=1 ; i < numbers.length - 1 & j< numbers.length; i++ , j++) {
                int sum = numbers[i] + numbers[j];
                if(sum == target ) {
                    return new int[]{i+1, j+1};
                }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] test = {2,3,4};
        int[] result = new TwoSumII().twoSum(test, 6);
        System.out.println(Arrays.toString(result));

    }

}
