public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        List<Integer> sol = new ArrayList<Integer>();
        exploreMe(ret,sol,1,k,n);
        return ret;
    }
    
     private void exploreMe(List<List<Integer>> ret, List<Integer> sol, int start, int k, int n){
        if(sol.size() > k || n < 0) return;
        if(sol.size()  == k ){
            if(n == 0) ret.add(new ArrayList<Integer>(sol));
            return;
        }
        
        for(int i=start; i<=9; i++){
            sol.add(i);
            exploreMe(ret,sol,i+1,k,n-i);
            sol.remove(sol.size()-1);
        }
    }
}