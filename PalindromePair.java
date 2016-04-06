public class Solution {
   
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<String,Integer> dict = new HashMap<String,Integer>();
        HashSet<String> pairsFound = new HashSet<String>();
        
        for(int i=0; i<words.length; i++){
            dict.put(words[i],i);
        }
        
        for(int i=0; i<words.length; i++){
            String word = words[i];

            //iterate through substring of word
            for(int j=word.length(); j>=0; j--){
                String part1 = word.substring(0,j);
                String part2 ="";
                try{
                   part2 = word.substring(j, word.length());
                }catch(Exception e){
                    part2 = "";
                }
                String rpart1 = reverse(part1);
                String rpart2 = reverse(part2);
                
                //part2 is center, part1-part2-rpart1
                if(isPalindrome(part2) && dict.containsKey(rpart1)){
                    int p = dict.get(rpart1);
                    //remove self pair and duplicate pairs
                    if(i != p && !pairsFound.contains(i+","+p)){
                       addPair(result, i, p);
                       pairsFound.add(i+","+p);
                    }
                }
                 
                //part1 is center, rpart2-part1-part2
                if(isPalindrome(part1) && dict.containsKey(rpart2)){
                    int p = dict.get(rpart2);
                    //remove self pair and duplicate pairs
                    if(i != p && !pairsFound.contains(p+","+i)){
                       addPair(result, dict.get(rpart2), i);
                       pairsFound.add(p+","+i);
                    }
                }
            }
        }
        return result;
    }
    
    private String reverse(String str){
        if(str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }
    
    private void addPair(List<List<Integer>> ret, int i, int j){
        List pair = new ArrayList<Integer>(2);
        pair.add(i);
        pair.add(j);
        ret.add(pair);
    }
    private boolean isPalindrome(String str){
        if(str.length() == 0) return true;
        char[] array = str.toCharArray();
        int i=0, j=array.length-1;
        while(i<j){
            if(array[i] != array[j])
               return false;
            i++; j--;
        }
        return true;
    }
} 
