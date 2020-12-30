package com.guier.dp;

import java.util.Arrays;

/**
 * 122. Best Time to Buy and Sell Stock II
 */
public class BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit(prices));
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit1(prices));
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) res += tmp;
        }
        return res;
    }

    /**
     * 暴力递归
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int res = 0;
        // for (int buy = 0; buy < prices.length; buy++) {//第几天买
        //     for (int sell = buy + 1; sell < prices.length; sell++) {//第几天卖掉，穷举所有情况，找到第X天买的最大收益。
        //         res = Math.max(res, prices[sell] - prices[buy] + dp(prices, sell + 1));//今天卖的+后续交易的等于本次售卖的最大值，交易次数不限制。
        //     }
        // }
        int[] memo = new int[prices.length];
        Arrays.fill(memo, -1);
        int dp = dp(memo, prices, 0);
        System.out.println(Arrays.toString(memo));
        return dp;
    }

    // public int dp(int[] prices, int begin) {
    //     int res = 0;
    //     for (int buy = begin; buy < prices.length; buy++) {//第几天买
    //         for (int sell = buy + 1; sell < prices.length; sell++) {//第几天卖掉，穷举所有情况，找到第X天买的最大收益。
    //             res = Math.max(res, prices[sell] - prices[buy] + dp(prices, sell + 1));
    //         }
    //     }
    //     return res;
    // }

    public int dp(int[] memo, int[] prices, int begin) {
        if (begin >= prices.length) return 0;

        if (memo[begin] != -1) {
            return memo[begin];
        }
        int res = 0;
        // for (int buy = begin; buy < prices.length; buy++) {//第几天买
        //     for (int sell = buy + 1; sell < prices.length; sell++) {//第几天卖掉，穷举所有情况，找到第X天买的最大收益。
        //         res = Math.max(res, prices[sell] - prices[buy] + dp(prices, sell + 1));
        //     }
        // }

        int min = prices[begin];
        for (int cell = begin + 1; cell < prices.length; cell++) {
            if (prices[cell] < min) min = prices[cell];
            res = Math.max(res, prices[cell] - min + dp(memo, prices, cell + 1));
            memo[begin] = res;
        }
        return res;
    }

}
