package leetCode.algorithms.one;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        RotateArray.rotate(nums, k);
        for (int num : nums) {
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1){
                System.out.print(nums[i]);
            } else {
                System.out.print(nums[i]  + ", ");
            }
        }
    }
    public static void rotate(int[] nums, int k) {
        int j = 0;
//        int startIndex =
        for (int i = nums.length - k - 1; i < nums.length ; i++) {
            int x = nums[i];
            //nums[i] = nums[]
        }
    }
}
