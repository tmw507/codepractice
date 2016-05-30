/*
33. Search in Rotated Sorted Array   My Submissions QuestionEditorial Solution
Total Accepted: 100179 Total Submissions: 330668 Difficulty: Hard
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        return searchUtil(nums, target, 0, nums.length-1);
    }
    private int searchUtil(int[] nums, int target, int s, int t){
        if(t<s) return -1;
        if(s == t) return nums[s] == target? s : -1;
        int mid = s + (t-s)/2;
        
        //System.out.println("s:"+s+" mid:"+mid+" t:"+t);
        if(target == nums[mid]) return mid;
        
        //have pivot point in [s, mid]
        if(nums[s] > nums[mid]){
            if(target > nums[mid] && target <= nums[t]){ // go to the range[mid+1, t]
                return searchUtil(nums, target, mid+1, t);
            }else{ //target < nums[mid] or target > nums[t]
                return searchUtil(nums, target, s, mid);
            }
        }else{// nums[s] <= nums[mid], pivot in the range [mid+1, t]
            if(target < nums[mid] && target >= nums[s]) return searchUtil(nums, target, s, mid);
            else  return searchUtil(nums, target, mid+1, t);
        }
    }
}