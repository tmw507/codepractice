/*
46. Permutations My Submissions Question
Total Accepted: 80163 Total Submissions: 237024 Difficulty: Medium
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

Hide Company Tags LinkedIn Microsoft
Hide Tags Backtracking
Hide Similar Problems (M) Next Permutation (M) Permutations II (M) Permutation Sequence (M) Combinations

*/
import java.lang.*;
import java.util.*;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0)return ret;
        permuteHelper(ret, nums, 0);
        return ret;
    }
    
    private void permuteHelper(List<List<Integer>> ret, int[] nums, int start ){
        if(start == nums.length){
            Integer[] oArray = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
            List<Integer> sol = new ArrayList<Integer>(Arrays.asList(oArray));
            ret.add(sol);
            return;
        }
        for(int i=start; i<nums.length; i++){
            swap(nums, start, i);
            permuteHelper(ret, nums, start+1);
            swap(nums, start, i);
        }
    }
    private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
    public static void main(String[] args){
        Permute s = new Permute();
        int[] nums = {1,2,3};
        s.permute(nums);
    }
}