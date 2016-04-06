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
                 neighbors.remove(i);
                 
                 if(dfs(graph,n, res, num) == true){
                     return true;
                 }
                 neighbors.add(i,n);
            }
        }
        res.removeLast();
        return false;
    }
}