/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 

example2
[1,1] 2
solution set is [[1,1]]

example3
[1,1] 1
solution set is [[1]]

*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0 || target <=0) return ret;
        Arrays.sort(candidates);   
        List<Integer> path = new ArrayList<Integer>();
        findPath(ret, path, candidates, 0, target);
        return ret;
    }
    
    private void findPath(List<List<Integer>> ret, List<Integer> path,int[] candidates,  int start, int target){
        
        if(target == 0){
            ret.add(new ArrayList<Integer>(path));
            return;
        }else if(target < 0) return;
        
        for(int i=start; i<candidates.length; i++){
            //remove duplicates
            if(i>start && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            findPath(ret, path, candidates, i+1, target-candidates[i]);
            path.remove(path.size()-1);
        }
       
    }
}