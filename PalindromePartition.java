
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String str) {
        // write your code here
        List<List<String>> ret = new ArrayList<List<String>>();
        int n = str.length();
        if(n == 0) return ret;
        short [][] palindromeBook = new short[n][n];
        for(int i=0; i<n; i++){
            palindromeBook[i][i] = 1;
        }
        ArrayList<String> solution = new ArrayList<String>();
        DFS(ret, solution, str, palindromeBook, 0, n-1);
        return ret;
    }
    
    public void DFS( List<List<String>> ret, ArrayList<String> solution, String str, short[][] palindromeBook, int s, int t){
        
        for(int i=s; i<=t; i++){
            if(palindromeBook[s][i] == 0){
                palindromeBook[s][i] = isPalindrome(str,s,i);
            }
            
            if(palindromeBook[s][i] == 1){
                solution.add(str.substring(s,i+1));
                if(i+1 <= t)
                   DFS(ret, solution,str, palindromeBook, i+1, t);
                else{// done with current exploration
                    ArrayList<String> one = new ArrayList<String>(solution);
                    ret.add(one);
                }   
                solution.remove(solution.size()-1);
            }
        }
    }
    
    short isPalindrome(String str, int s, int t){
        if( t < s) {int temp = t; t=s; s=temp;}
        char[] array = str.toCharArray();
        while(s<t){
            if(array[s] != array[t])
               return -1;
            s++;
            t--;
        }
        return 1;
    }
}
