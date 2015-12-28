
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(edges==null|| (n>1 && edges.length==0) ) return false;
        if(edges.length==0 && n==1) return true;
        Map<Integer, ArrayList<Integer> > neighbors = new HashMap<Integer, ArrayList<Integer> >();
        for(int i=0; i<edges.length; i++){
            if(!neighbors.containsKey(edges[i][0])){
                neighbors.put(edges[i][0], new ArrayList<Integer>());
            }
            neighbors.get(edges[i][0]).add(edges[i][1]);
            
            if(!neighbors.containsKey(edges[i][1])){
                neighbors.put(edges[i][1], new ArrayList<Integer>());
            }
            neighbors.get(edges[i][1]).add(edges[i][0]);
        }
        int[] color = new int[n];
        for(int i=0; i<n; i++){
            color[i] = 0;
        }
        boolean ret = hasCycle(neighbors, 0, -1, color);
       
        for(int i=0; i<n; i++){
            if(color[i] == 0)
                return false;
        }
        return !ret;
    }
    
    public boolean hasCycle(Map<Integer, ArrayList<Integer> > neighbors,
                            Integer current, Integer parent,
                            int[] color
    ){
        //mark current node as visiting
        color[current] = 1;
        
        //go over the neighbor node
        ArrayList<Integer> myneighs = neighbors.get(current);
        if(myneighs == null) return false;
        
        for(Integer v: myneighs){
          //System.out.println("v:"+v+" color:"+color[v]);
          //back edge for both directed and undirected graph
          if(color[v] == 1 && !v.equals(parent)){
               return true;
          }
          if(color[v] == 0){
               if(hasCycle(neighbors,v,current,color))
                  return true;
          }   
        }
        // mark current node as visited, all the children nodes have been visted.
        color[current] = 2;
        return false;
    }
}
