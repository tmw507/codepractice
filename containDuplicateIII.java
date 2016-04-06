/*
* Given an array of integers, find out whether there are two distinct
* indices i and j in the array such that the difference between nums[i] 
* and nums[j] is at most t and the difference between i and j is at most k.
*/
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if( k<1 || t < 0) return false;
        TreeSet<Integer> dict = new TreeSet<Integer>();
        
        for(int i=0; i<nums.length; i++){
            int fromElem = nums[i]-t;  //inclusive
            int toElem = nums[i]+t+1;  //exclusive
            
            if((long) nums[i] - (long) t < Integer.MIN_VALUE) fromElem = Integer.MIN_VALUE;
            if((long) nums[i] + (long) t + 1 > Integer.MAX_VALUE) toElem = Integer.MAX_VALUE;
            if(dict.subSet(fromElem,toElem).size() != 0) return true;
            dict.add(nums[i]);
            if(dict.size() > k) dict.remove(nums[i-k]);
        }
        return false;
    }
}