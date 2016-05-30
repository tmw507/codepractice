/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        char[] arrays = s.toCharArray();
        char[] arrayp = p.toCharArray();
        boolean[][] dp = new boolean[lens+1][lenp+1];
        
        if(p.length() == 0 && lens > lenp) return false;
        //dp[i][j]: first i chars in S matches first j chars in P?
        dp[0][0] = true;
        
        for(int i=0; i<=lens; i++){
            for(int j=1; j<=lenp; j++){
                if(j>1 && arrayp[j-1] == '*'){
                    dp[i][j] = dp[i][j-1];
                }else {
                    boolean isMatchPair = false;
                    if(i>0){
                       isMatchPair = arrayp[j-1] == '.'? true: arrays[i-1] == arrayp[j-1]; 
                    }
                    if(j < lenp && arrayp[j] == '*'){
                        boolean oneOrMany = i>0?(dp[i-1][j-1] && isMatchPair || dp[i-1][j] && isMatchPair) :false;
                        dp[i][j] = dp[i][j-1] || oneOrMany;
                    }else{    
                        dp[i][j] = i>0? dp[i-1][j-1] && isMatchPair : false;
                    }    
                }
            }
        }
        return dp[lens][lenp];
    }
}