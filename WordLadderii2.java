class TreeNode{
   public String val;
   public TreeNode prev;
   public TreeNode(String val, TreeNode prev){
       this.val = val;
       this.prev = prev;
   }
}
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(beginWord == null || endWord == null) return res;
        Map<String,Integer> map = new HashMap<String,Integer>();
        TreeNode start = new TreeNode(beginWord, null);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(start);
        wordList.add(endWord);
        
        boolean found = false; int level = 0;
        map.put(beginWord, 0);
        
        while(!found && !queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                TreeNode top = queue.poll();
                String curWord = top.val;
                
                if(curWord.equals(endWord)){
                    found = true;
                    LinkedList<String> path = new LinkedList<String>();
                    TreeNode temp = top;
                    while(temp != null){
                       path.addFirst(temp.val);
                       temp = temp.prev;
                    }
                    res.add(path);
                }else{
                    char[] carray = curWord.toCharArray();
                    for(int j=0; j<carray.length; j++){
                         char c = carray[j];
                         for(char a='a'; a<='z'; a++){
                             if(a != c){
                                 carray[j]=a;
                                 String newWord = new String(carray);
                                 //duplciate word can only occure on the same level, but not going back
                                 if(wordList.contains(newWord) && (!map.containsKey(newWord) || map.get(newWord) == level )){
                                      TreeNode node = new TreeNode(newWord,top);   
                                      queue.add(node);
                                      map.put(newWord, level);                  
                                 }
                             }
                         }
                         carray[j] = c;
                    }
                }
            }
            level++;
        }
        return res;
    }
}