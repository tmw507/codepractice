import java.lang.*;
import java.util.*;

public class Permute2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0)return ret;
        Arrays.sort(nums);
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
        //pick up a position to swap with start and do permutation on [start+1,n)
        for(int i=start; i<nums.length; i++){
            //if(i>start && nums[i]==nums[start] ) continue;
	    if(dupsolution(nums, start, i)) continue;
            System.out.println("start:"+start+" i:"+i);
            swap(nums, start, i);
            permuteHelper(ret, nums, start+1);
            swap(nums, start, i);
        }
    }
    boolean dupsolution(int[] nums,int step,int end){
        //if in range [index,j),there exists number equals num[j],the swap with j is a dupsolution,we swap them early.so we pass by
	for(int i=step; i<end; ++i){
	    if(nums[i] == nums[end])
		return true;
	}
	return false;
    }
    private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
    public static void main(String[] args){
        Permute2 s = new Permute2();
        int[] nums = {1,1,0,0,1,-1,-1,1};
        s.permuteUnique(nums);
    }
}
