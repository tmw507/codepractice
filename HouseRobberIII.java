/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
       int[] profit = robUtil(root);
       return Math.max(profit[0], profit[1]);
    }

    private int[] robUtil(TreeNode root){
         int[] profit = {0,0};
         if(root == null){
            return profit;
         }else if(root.left == null && root.right == null){
            profit[0] = 0; profit[1] = root.val;
         }else{
            int[] leftProfit = robUtil(root.left);
            int[] rightProfit = robUtil(root.right);

            //exclude root.val, then take the max of(each subtree) and plus them together
            profit[0] = Math.max(leftProfit[0],leftProfit[1])+ Math.max(rightProfit[0],rightProfit[1]);
            //include root.val + subtree excluede its subroot value
            profit[1] = leftProfit[0] + rightProfit[0] + root.val;
         }
         return profit;
    }
}