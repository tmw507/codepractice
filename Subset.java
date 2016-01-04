//*******************************************************************
// Java compiler created in PHP to quickly and safely test code.
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************

import java.lang.Math; // header stuff MUST go above the first class
import java.util.*;


public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        assert nums != null;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        subsetFromMe(nums, ret, sol, 0);
        return ret;
    }
    
    //depth first search solutions start from index
    private void subsetFromMe(int[] nums, List<List<Integer>> ret, List<Integer> sol, int index){
        ret.add(new ArrayList<Integer>(sol));
        for(int i=index; i<nums.length; i++){
            sol.add(nums[i]);
            subsetFromMe(nums, ret, sol, i+1);
            sol.remove(sol.size()-1);
        }
    }
  private void print(List<Integer> sol){
      for(Integer v: sol){
          System.out.print(v+" ");
      }
      System.out.println();
  }
  public static void main(String[] args){
       Subset s = new Subset();
    int[] nums = {1,2,3,4,5,6,7,8,9,10,0};
       List<List<Integer>> ret = s.subsets(nums);
  }
}