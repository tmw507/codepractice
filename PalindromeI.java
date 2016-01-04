public class Solution{
	public Vector<Vector<String>> partition(String s) {
        Vector<Vector<String>> ret = new Vector<Vector<String>>();
		if(s == null || s.length() < 1) return ret;
        int n = s.length();
        char[] str = s.toCharArray();

		boolean[][] P = new boolean[n][n];
		for(int i=n-1; i>=0; i--){
			for(int j=i; j<=n-1; j++){
				//cross over or same element, || comparable i,j
				if(i+1>=j-1||(P[i+1,j-1] && str[i] == str[j])){
					  P[i,j] = true;
				}	
			}
		}
	}
	
	public boolean DFS(String s, boolean[][] P, int start, int end, Vector<Vector<String>> ret, Vector<String> sol)
	{
		if(start >= end) return true;

		for(int i=start; i<=end; i++){
			 
             if(P[i][end] && DFS(s,P,start,i-1,ret)){
                 sol.add(s.substring(i,end))
                 ret.add(new Vector<String>(sol));
                 sol.remove(sol.size()-1);
             }
		}

	}
}