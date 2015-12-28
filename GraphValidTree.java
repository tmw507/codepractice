public class GraphValidTree {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        //direct parent
        int[] dp = new int[n];
        int[] rank = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = i;
            rank[i] = 1;
        }
        int nCollections = n;
        int nRows = edges.length;
        for(int i=0; i<nRows; i++){
            boolean ret = union(edges[i][0], edges[i][1], dp, rank);
            if(ret) 
                nCollections--;
            else
                return false; //add edge belong to the same group
        }
        return nCollections == 1;
    }
    
    //return the leader of x's party
    //using path compression
    int Find(int x, int[] dp){
        if(dp[x] != dp[dp[x]]) dp[x] = Find(dp[x], dp);
        return dp[x];
    }
    
    //using merge by rank
    boolean union(int x, int y, int[] dp, int[] rank){
        int dpx = Find(x,dp);
        int dpy = Find(y,dp);
        if(dpx == dpy) return false; //no need to merge
        
        if(rank[dpx] > rank[dpy]) {int z=dpx ^ dpy; dpx=dpx^z; dpy = dpy ^ z;}
        if(rank[dpx] == rank[dpy]) rank[dpy]++;
        dp[dpx] = dpy;
        return true;
    }
}
