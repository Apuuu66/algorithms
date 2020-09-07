package com.guier.array;

/**
 * 11. Container With Most Water
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = new ContainerWithMostWater().maxArea(height);
        System.out.println(maxArea);
    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHight = height[i] > height[j] ? height[j--] : height[i++];
            int area = (j - i + 1) * minHight;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    // public int maxArea(int[] height) {
    //     int maxArea = 0;
    //     for (int i = 0; i < height.length; i++) {
    //         for (int j = i + 1; j < height.length; j++) {
    //             int minHight = Math.min(height[i], height[j]);
    //             int area = (j - i) * minHight;
    //             maxArea = Math.max(maxArea, area);
    //         }
    //     }
    //     return maxArea;
    // }
}
