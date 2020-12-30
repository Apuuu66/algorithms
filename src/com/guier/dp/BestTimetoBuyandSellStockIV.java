package com.guier.dp;

/**
 * 124. Best Time to Buy and Sell Stock IV
 */
public class BestTimetoBuyandSellStockIV {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        // int[] prices = {7,6,4,3,1};
        System.out.println(new BestTimetoBuyandSellStockIV().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int k = 2;

        return dp(prices, 0, k);
    }

    public int dp(int[] prices, int begin, int k) {
        if (begin >= prices.length || k == 0) {
            return 0;
        }
        int res = 0;
        int min = prices[begin];
        for (int cell = begin + 1; cell < prices.length; cell++) {
            if (prices[cell] < min) min = prices[cell];
            res = Math.max(res, prices[cell] - min + dp(prices, cell + 1, k - 1));
        }
        return res;
    }

}
