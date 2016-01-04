public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(n==0) return ret;
        
        List<Integer> sol = new ArrayList<Integer>();
        exploreMe(ret,sol,1,k,n);
        return ret;
    }
    
    private void exploreMe(List<List<Integer>> ret, List<Integer> sol, int start, int k, int n){
        if(sol.size() == k){
            ret.add(new ArrayList<Integer>(sol));
            return;
        }
        
        for(int i=start; i<=n; i++){
            sol.add(i);
            exploreMe(ret,sol,i+1,k,n);
            sol.remove(sol.size()-1);
        }
    }
}