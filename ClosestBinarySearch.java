import java.lang.Math; // header stuff MUST go above the first class
import java.util.*;

public class ClosestBinarySearch {
    public int searchInsert(int[] nums, int target) {
        float ftarget = target - 0.0001f;
        return search(nums, ftarget);   
    }
    private int search(int[] nums, float target){
        int start = 0, end = nums.length-1;
        int mid = 0;
        while(start < end){
            mid = start + (end-start)/2;
            if(nums[mid] > target){
                end = mid;
            }else { //nums[mid] <= target
                start = mid+1;
            }
        }
        if(nums[end] < target) return end + 1;
        return end;
    }

    public static void main(String[] args){
        
        ClosestBinarySearch S = new ClosestBinarySearch();
        int[] nums ={1,2,5,8};
        int pos = S.searchInsert(nums,9 );
        System.out.println(pos);
    }
}