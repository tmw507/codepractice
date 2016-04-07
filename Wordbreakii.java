public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> res = new ArrayList<String>();
        if(s==null || wordDict == null ) return res ;
        
        int n = s.length();
        int maxLen = -1;
        for(String word: wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        
        HashMap<Integer, ArrayList<String>> wordsMap = new HashMap<Integer, ArrayList<String>>();
        
        return wordBreakHelper(s, 0, wordsMap, maxLen, wordDict);
    }
    
    private ArrayList<String> wordBreakHelper(String s, int start, HashMap<Integer, ArrayList<String>> wordsMap, int maxLen, Set<String> wordDict){
        ArrayList<String> res = new ArrayList<String>();
        if(start >= s.length()) return res;
        
        //check whether the word list exist in the cache or not
        if(wordsMap.containsKey(start)) return wordsMap.get(start);
        
        for(int len=1; len <= maxLen && start+len <= s.length(); len++){
            int rightPos = start+len;
            String word = s.substring(start, rightPos);
            if(wordDict.contains(word)){
                ArrayList<String> wordsList = wordBreakHelper(s, rightPos, wordsMap, maxLen, wordDict);
                if(wordsList.size() > 0){
                    for(String path: wordsList){
                       String newPath = word+" "+path;
                       res.add(newPath);
                    }
                }else if(rightPos == s.length()){ // if we have reached the last word in s.
                    res.add(word);
                }
            }
        }
        //definitely put the word list from start positon into the cache after computation is done, sub problem will be covered
        //by the recursive call of wordBreakHelper.
        wordsMap.put(start,res);
        return res;
    }
}