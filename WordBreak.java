public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || wordDict == null) return false;
        
        boolean[] breakable = new boolean[s.length()+1];
        //"" is available in wordDict
        breakable[0] = true;
        
        // i : length of the substring(0, i)
        for(int i=1; i<= s.length(); i++){
            breakHelper(s, wordDict, breakable, i);
        }
        return breakable[s.length()];
        
    }
    private void breakHelper(String s, Set<String> wordDict, boolean[] breakable, int len){
        
        for(int i=0; i< len; i++){
            if(breakable[i]&& wordDict.contains(s.substring(i,len))){
                breakable[len] = true;
                break;
            }
        }
    }
}