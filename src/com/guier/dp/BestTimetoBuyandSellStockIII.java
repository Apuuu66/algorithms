package com.guier.dp;

import java.util.Arrays;

/**
 * 123. Best Time to Buy and Sell Stock III
 */
public class BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        // int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {9949,550,814,5971,7537,8801,16458,3999,23858,26324,4702,29594,10988,29657,
                26980,20682,3208,2903,11868,12098,9781,29588,8787,93,600,20968,20719,8307,29612,16680,
                19231,2280,5328,25499,19135,17035,1266,21010,9786,3997,2884,14787,24514,13488,3481,7023,28055,3888,
                8891,18238,10006,11479,27098,21443,28891,13286,11103,27360,29894,14075,28045,7836,7487,27747,9410,8719,
                22410,23412,25611,10341,28179,4552,173,24557,21361,7739,1105,22234,26685,20647};
        System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int k = 2;
        int[][] memo = new int[k + 1][prices.length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(memo, prices, 0, k);
    }

    public int dp(int[][] memo, int[] prices, int begin, int k) {

        if (begin >= prices.length || k == 0) {
            return 0;
        }
        if (memo[k][begin] != -1) {
            return memo[k][begin];
        }
        int res = 0;
        int min = prices[begin];
        for (int cell = begin + 1; cell < prices.length; cell++) {
            if (prices[cell] < min) min = prices[cell];
            res = Math.max(res, prices[cell] - min + dp(memo, prices, cell + 1, k - 1));
            memo[k][begin] = res;
        }
        return res;
    }

}
