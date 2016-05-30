/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
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
 class Pair{
     public TreeNode node;
     public int column;
     public Pair(TreeNode node, int column){
         this.node = node;
         this.column = column;
     }
 }
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new  ArrayList<List<Integer>>();
        if(root == null ) return res;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int l=Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        
        Queue<Pair> Q = new LinkedList<Pair>();
        Q.add(new Pair(root,0));
        while(true){
            int size = Q.size();
            for(int i=0; i<size; i++){
                Pair entry  = Q.poll();
                if(!map.containsKey(entry.column)) map.put(entry.column, new LinkedList<Integer>());
                map.get(entry.column).add(entry.node.val);
                if(entry.node.left != null) Q.add(new Pair(entry.node.left, entry.column-1));
                if(entry.node.right != null) Q.add(new Pair(entry.node.right, entry.column+1));
                l = Math.min(l, entry.column);
                r = Math.max(r, entry.column);
            }
            if(Q.size() == 0) break;
        }
        for(int i=l; i<=r; i++){
            res.add(map.get(i));
        }
        return res;
    }
   
}