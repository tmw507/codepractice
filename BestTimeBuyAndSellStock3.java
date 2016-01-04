/**
123. Best Time to Buy and Sell Stock III My Submissions Question
Total Accepted: 48427 Total Submissions: 192066 Difficulty: Hard
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Show Tags
Show Similar Problems
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length == 0) return 0;
        int n = prices.length;
        int profitOne = 0, minPrice = prices[0];
        int[] profits = new int[n];
        
        for(int i=1; i<n; i++){
            minPrice = Math.min(minPrice, prices[i]);
            profitOne = Math.max(profitOne, prices[i] - minPrice);
            profits[i] = profitOne;
        }
        int maxPrice = prices[n-1], profitTwo = 0, maxProfit = profits[n-1];
        for(int i=n-2; i>=0; i--){
            maxPrice = Math.max(maxPrice, prices[i]);
            profitTwo = Math.max(profitTwo, maxPrice - prices[i]);
            if(i>0)
                maxProfit = Math.max(maxProfit, profits[i-1] + profitTwo );
        }
        return maxProfit;
    }
}