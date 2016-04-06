public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<String>();
        if(tickets == null || tickets.length == 0) return res;
        
        HashMap<String, ArrayList<String>> graph = new HashMap<String,ArrayList<String>>();
        for(String[] pair: tickets){
            if(!graph.containsKey(pair[0])){
                graph.put(pair[0], new ArrayList<String>());
            }
            graph.get(pair[0]).add(pair[1]);
        }
        for(ArrayList<String> list: graph.values()){
            Collections.sort(list);
        }
        dfs(graph, "JFK", res, tickets.length+1);    
        return res;
    }
    
    private boolean dfs(HashMap<String,ArrayList<String>> graph, String start, LinkedList<String> res, int num ){
        ArrayList<String> neighbors = graph.get(start);
        res.add(start);
        if(res.size() == num) return true;
        if(neighbors != null){
            for(int i=0; i<neighbors.size(); i++){
                 String n = neighbors.get(i);
                 //equivalently mark the ith' node as visited
                 neighbors.remove(i);
                 //go deep to recursively explore the valid path
                 if(dfs(graph,n, res, num) == true){
                     return true;
                 }
                 //backtracking by add the node to ith' position
                 neighbors.add(i,n);
            }
        }
        //backtracking by removing the last added node in res at some level of dfs failed to find a valid solution.
        res.removeLast();
        return false;
    }
}
