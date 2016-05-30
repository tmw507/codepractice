/***
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
*/
public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int left=0, right = height.length-1;
        int lh = height[left], rh = height[right];
        int sum = 0;
        
        while(left < right){
            lh = Math.max(lh, height[left]);
            rh = Math.max(rh, height[right]);
            if(height[left] <= height[right]){
                sum += Math.min(lh,rh)-height[left];
                left++;
            }else{
                sum += Math.min(lh,rh) - height[right];
                right--;
            }
        }
        return sum;
    }
}