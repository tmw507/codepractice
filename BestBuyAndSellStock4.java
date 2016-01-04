/**
*188. Best Time to Buy and Sell Stock IV My Submissions Question
*Total Accepted: 19672 Total Submissions: 95168 Difficulty: Hard
*Say you have an array for which the ith element is the price of a given stock on day i.
*
*Design an algorithm to find the maximum profit. You may complete at most k transactions.
*
*Note:
*You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*
*Credits:
*Special thanks to @Freezen for adding this problem and creating all test cases.
*
*Show Tags
*Show Similar Problems
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        int n = prices.length;
        //use as many transactions as possible method
        int maxProfit = 0;
        if(k>=n/2){
            for(int i=1; i<n; i++){
                if(prices[i] - prices[i-1] > 0)
                    maxProfit += prices[i] - prices[i-1];
            }
            return maxProfit;
        }
     
        int[][] profits = new int[n][n];
        for(int j=1; j<=k; j++){ 
            int localMax = -prices[0];
            for(int i=1; i<prices.length; i++){
               profits[j][i] = Math.max(profits[j][i-1], prices[i]+localMax);
               /// iterate profits[j-1][u]-prices[u]
               localMax = Math.max(localMax, profits[j-1][i]-prices[i]); 
            }
        }
        return profits[k][n-1];
    }
}