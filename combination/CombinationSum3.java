/**
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * 
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(n == 0 ) return ret;
        
        List<Integer> path = new ArrayList<Integer>();
        findPath(ret, path, 1, k, n);
        return ret;
    }
    
    private void findPath(List<List<Integer>> ret, List<Integer> path, int start, int k, int target){
        if(target == 0 && path.size() == k){
            ret.add(new ArrayList<Integer>(path));
            return;
        }else if(target < 0) return;
        
        for(int i=start; i<=9; i++){
            path.add(i);
            findPath(ret, path, i+1, k, target-i);
            path.remove(path.size()-1);
        }
    }
}
