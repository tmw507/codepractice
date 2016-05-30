public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null || str == null ) return false; 
        return matchUtil(pattern, str, 0,0, new HashMap<Character,String>(), new HashSet<String>());
    }
    
    private boolean matchUtil(String pattern, String str, int p, int s, HashMap<Character,String> map, HashSet<String> occupy){
        if(p>= pattern.length() ){
            return s>=str.length();
        }else if(s>= str.length()){
            return p>= pattern.length();
        }
        // System.out.println(p+" "+s);
        // for(Map.Entry<Character,String> entry: map.entrySet()){
        //     System.out.println(entry.getKey()+" "+entry.getValue());
        // }
        if(map.containsKey(pattern.charAt(p))){
            String word = map.get(pattern.charAt(p));
            if(s+word.length() > str.length() || !word.equals(str.substring(s, s+word.length()))) return false;
            
            boolean ret = matchUtil(pattern, str, p+1, s+word.length(), map, occupy);
            if(ret == true) return true;
            else{
                map.remove(pattern.charAt(p));
                return false;
            }    
        }else{// new char
            int len = 0;
            for(int i=p+1; i<pattern.length(); i++){
                int l = map.containsKey(pattern.charAt(p))? map.get(pattern.charAt(p)).length(): 1;
                len += l;
            }
            for(int i=s+1; i<=str.length() - len; i++){
                String attempt = str.substring(s, i);
                if(occupy.contains(attempt)) continue;
                occupy.add(attempt);
                map.put(pattern.charAt(p), attempt);
                boolean ret = matchUtil(pattern, str, p+1, i, map, occupy);
                if(ret == true) return true;
                map.remove(pattern.charAt(p));
                occupy.remove(attempt);
            }
            return false;
        }
    }
}