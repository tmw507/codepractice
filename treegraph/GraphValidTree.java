/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 *
 * For example:
 *
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * Hint:
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 * According to the definition of tree on Wikipedia: "tree is an undirected graph in which any two vertices are connected byexactly one path. In other words, any connected graph without simple cycles is a tree."
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */

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
