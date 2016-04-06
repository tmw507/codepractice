/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

public class Solution {
    class DictComparator implements Comparator<String>{
        public int compare(String a, String b){
            return (a+b).compareTo(b+a);
        }
    }
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if(nums == null || nums.length == 0) return sb.toString();
        
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]+"");
        }
        
        Collections.sort(list, new DictComparator());
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i));
        }
        if(sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}