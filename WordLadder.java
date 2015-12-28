import java.util.*;

public class WordLadder {
    class Entry{
        public String word;
        public int len;
        public Entry(String word, int len){
            this.word = word;
            this.len = len;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<Entry> Q = new LinkedList<Entry>();
        if(wordList == null || wordList.size()==0 ) return 0;
        
        wordList.add(endWord);
        Entry start = new Entry(beginWord, 1);
        Q.add(start);
        
        while(!Q.isEmpty()){
            Entry entry = Q.poll();
            int len = entry.len;
            if(entry.word.equals(endWord)) return entry.len;
            Set<String> neighbors = getNeighbors(entry.word, wordList);
            Iterator<String> it = neighbors.iterator();
            while(it.hasNext()){
                String neighbor = it.next();
                Entry ngh = new Entry(neighbor, len+1);
                Q.add(ngh);
            }
        }
        return 0;
    }
    
    public static Set<String> getNeighbors(String word, Set<String> wordList){
        Set<String> ret = new HashSet<String>();
        
        char[] array = word.toCharArray();
        for(int i=0; i<array.length; i++){
            char c = array[i];
            for(char a='a'; a<='z'; a++){
                if(c == a)continue;
                array[i] = a;
                String str = new String(array);
                if(wordList.contains(str)){
                    ret.add(str);
                    wordList.remove(str);
                    System.out.println(str);
                }
            }
            array[i] = c;
        }
        return ret;
    }
    public static void main(String[] args){
        WordLadder s = new WordLadder();
        Set<String> wordList = new HashSet<String>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");
        int len = s.ladderLength("a","b",wordList);
        System.out.println(len);
    }
}