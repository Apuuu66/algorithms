package com.guier.stack;

/**
 * 84. Largest Rectangle in Histogram
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
    }


    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int j = i, k = i;
            while (j - 1 >= 0 && heights[j-1] >= heights[i]) {
                j--;
            }
            while (k + 1 < heights.length && heights[k+1] >= heights[i]) {
                k++;
            }
            System.out.println(i + "-" + j + "-" + k);
            int tmp = heights[i] * (k - j + 1);
            maxArea = Math.max(maxArea, tmp);
        }
        return maxArea;
    }
}
