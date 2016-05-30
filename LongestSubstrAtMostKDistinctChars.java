/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
*/
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k==0) return 0;
        char[] array = s.toCharArray();
        int len = 1, p1=0, p2=1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(array[0],1);
        
        
        while(p2<array.length){
            char c = array[p2];
            if(map.containsKey(c)){ 
                map.put(c, map.get(c)+1);
                len = Math.max(len, p2-p1+1);
            }else{
                len = Math.max(len, p2-p1);
                while(map.keySet().size() >=k ){
                    map.put(array[p1], map.get(array[p1])-1);
                    if(map.get(array[p1]) == 0)
                       map.remove(array[p1]);
                    p1++;
                }
                map.put(c,1);
                len = Math.max(len, p2-p1+1);
            }
            p2++;
        }
        return len;
    }
}