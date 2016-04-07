/* TrieNode class
 * use char value [a-z] as key of the Trie node, and routing a word through the trie (prefix tree)
 * for adding a new word or search in the Trie. Store the word associated with the node once the 
 * word characters have been exhaused.
 * note on trie on wiki: <a href="https://en.wikipedia.org/wiki/Trie"> Trie</a>
 */
class TrieNode{
    public TrieNode[] next;
    public String val;
    public TrieNode(){
        next = new TrieNode[26];
        val = null;
    }
}
public class WordDictionary {
    public TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null || word.isEmpty() ) return;
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.next[c-'a'] == null){
                node.next[c-'a'] = new TrieNode();
            }
            node = node.next[c-'a'];
        }
        node.val = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchUtil(word, 0, root);
    }
    private boolean searchUtil(String word, int start, TrieNode startNode){
        if(word == null || startNode == null) return false;
        if(start >= word.length() ) return startNode.val != null;
        char c = word.charAt(start);
        if(c == '.'){
            for(TrieNode t: startNode.next){
               if(t == null) continue;
               boolean ret = searchUtil(word, start+1, t);
               if(ret == true) return true;
            }
            return false;
        }else{
            return searchUtil(word, start+1,startNode.next[c - 'a'] );
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");