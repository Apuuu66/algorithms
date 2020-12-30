package com.guier.dp;

/**
 * 121. Best Time to Buy and Sell Stock
 * 思路：利用最值，去判断后一天是否最佳卖掉
 */
public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(prices));
        System.out.println(new BestTimetoBuyandSellStock().maxProfit1(prices));
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int cell = 1; cell < prices.length; cell++) {
            if (prices[cell] < min) min = prices[cell];
            res = Math.max(res, prices[cell] - min);
        }
        return res;
    }


    /**
     * 暴力递归
     * 我们相当于固定了买入时间 buy，然后将 buy 后面的每一天作为 sell 进行穷举，只为寻找 prices[sell] 最大的那天，因为这样 prices[sell] - prices[buy] 的差价才会最大。
     * 如果反过来想，固定卖出时间 sell，向前穷举买入时间 buy，寻找 prices[buy] 最小的那天，是不是也能达到相同的效果？是的，而且这种思路可以减少一个 for 循环。
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int res = 0;
        for (int buy = 0; buy < prices.length; buy++) {//第几天买
            for (int sell = 1; sell < prices.length; sell++) {//第几天卖掉，穷举所有情况，找到第X天买的最大收益。
                res = Math.max(res, prices[sell] - prices[buy]);
            }
        }
        return res;
    }
}
