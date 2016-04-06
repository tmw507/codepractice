public class Solution {
    private String reverse(String word){
        char[] array = word.toCharArray();
        int i=0, j=array.length-1;
        char temp;
        while(i<j){
           temp = array[i];
           array[i] = array[j];
           array[j] = temp;
           i++;
           j--;
        }
        return new String(array);
    }
    public String reverseWords(String s) {
        if(s==null || s.size() == 0) return "";
        String rs = reverse(s);
        String[] words = rs.split(" ");

        //import to use StringBuffer to store word concatenation instead of
        //word + which incurs n^2 where n is the final length of the concatenated string.
        StringBuffer result = new StringBuffer();
        
        int count = 0;
        for(String word: words){
            if(word.isEmpty()) continue;
            result.append(reverse(word));
            result.append(" ");
            count++;
        }
        
        if(count > 0)
            result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}