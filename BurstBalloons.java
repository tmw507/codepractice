import java.util.*;

class Entry{
	public int s;
	public int t;
	public Entry(int s, int t){
		this.s = s;
		this.t = t;
	}
}
public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        HashMap<Entry, Integer> map  = new HashMap<Entry,Integer>();
    }

    private int collectHelper(ArrayList<Integer> list, HashMap<Entry, Integer> map){
        int n = list.size();
        int sum = 0;
        for(int i=0; i< n; i++){
        	
        	int left = 1, right = 1;
        	if(i>0) left = list.get(i-1);
        	if(i<n-1) right = list.get(i+1);
        	int val = list.remove(i);
        	int localTripe = val * left * right;
            
            int localMax = collectHelper(list, map);
            sum = Math.max(sum, localMax + localTripe);
            list.add(i, val);
        }
        map.put()
        return sum;
    }
}