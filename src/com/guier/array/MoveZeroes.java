package com.guier.array;

import com.guier.tools.Tools;

/**
 * 283 Move Zeroes
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 9, 5, 0, 8, 0, 6, 0, 0, 0, 1};
        new MoveZeroes().moveZeroes(nums);
        Tools.print(nums);
    }

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // if (nums[i] != 0) {
            //     nums[k] = nums[i];
            //     if (i != k) {
            //         nums[i] = 0;
            //     }
            //     k++;
            // }

            // if (nums[i] != 0) {
            //     swap(nums, i, k);
            //     k++;
            // }

            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, i, k);
                }
                k++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
        // int tmp = nums[i];
        // nums[i] = nums[j];
        // nums[j] = tmp;
    }
}
