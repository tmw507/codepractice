/**
122. Best Time to Buy and Sell Stock II My Submissions Question
Total Accepted: 71860 Total Submissions: 176997 Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Show Tags
Show Similar Problems
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        int profit = 0, amin=prices[0], status = 0;
        
        for(int i=1; i<prices.length; i++){
            if(prices[i]>= prices[i-1]){
                status = 1;
            }else{ // prices[i] < prices[i-1]
                if(status == 1){
                    profit += prices[i-1] - amin;
                    amin = prices[i];
                }
                status = -1;
                amin = Math.min(amin, prices[i]);
            }
        }
        if(status == 1) profit += prices[prices.length-1] - amin;
        return profit;
    }
}