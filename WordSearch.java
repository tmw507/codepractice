class TrieNode{
   public String word;
   public TrieNode[] next;
   public TrieNode(){next = new TrieNode[26];}
}
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
    	List<String> res = new ArrayList<String>();
        if(board == null || words == null) return  res;

        TrieNode root = buildTrie(words);
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		dfs(board,i,j, root, res);
        	}
        }
        return res;
    }

private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res){
        char c = board[i][j];
    	if(c == '#' ||  root.next[c-'a'] == null) return;
        root =  root.next[c-'a'];
    	if(root.word != null ){
    		res.add(root.word);
    		root.word = null;
    		//don't return here since continue searching may lead to another word
    	}
    	
    	board[i][j] = '#';
    	if(i-1>=0) dfs(board, i-1, j, root, res); 
    	if(i+1 < board.length) dfs(board, i+1, j, root, res);	
    	if(j-1>=0) dfs(board, i, j-1, root, res); 
    	if(j+1 < board[0].length) dfs(board, i, j+1, root, res);
    	board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words){
    	TrieNode root = new TrieNode();
    	for(String word: words){
    		TrieNode p = root;
    		char[] array = word.toCharArray();
    		for(int i=0; i<array.length; i++){
                if(p.next[array[i]-'a'] == null){
                	p.next[array[i]-'a'] = new TrieNode();
                }
                p = p.next[array[i]-'a'];
    		}
    		p.word = word;
    	}
    	return root;
    }
}