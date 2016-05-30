public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        if(nums == null) return list;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums){
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }
        
        //O(n logk) method
        PriorityQueue<Map.Entry<Integer,Integer>> pq =
        new PriorityQueue<Map.Entry<Integer,Integer>>(k, new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
                if(a.getValue() < b.getValue()) return -1;
                else if(a.getValue() > b.getValue()) return 1;
                else return 0;
            }
        });
        
        Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Integer> pair = it.next();
            if(pq.size() < k) pq.add(pair);
            else{
                Map.Entry<Integer,Integer> top = pq.peek();
                if(top.getValue() < pair.getValue()){
                    pq.poll();
                    pq.add(pair);
                }
            }
        }
        while(pq.size() != 0){
            //Map.Entry<Integer,Integer> pair = pq.peek();
            //System.out.println(pair.getKey()+" "+pair.getValue());
            list.addFirst(pq.poll().getKey());
        }
        return list;
    }
    
}