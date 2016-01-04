/**
 Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
*/
//Solution: choose two init states for the first two numbers. Then, rotate verfying the sum
//sequence is valid, i.e. a path from starting two numbers to the final state. Therefore,
//we can view it as a dfs method. Backtrack: there n^2 ways for choosing the first two 
//numbers, if all of them fail return false; otherwise return true;
public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3) return false;
        for(int i=2; i < num.length(); i++){
             for(int j=1; j<i; j++){
                 if(num.charAt(j) == '0' && i-j>1) continue;
                 if(num.charAt(0) == '0' && j>1) continue;
                 long part1 = Long.parseLong(num.substring(0,j));
                 long part2 = Long.parseLong(num.substring(j, i));
                 boolean ret = verify(num, i, part1, part2);
                 if(ret == true) return true;
             }
        }
        return false;
    }
    //"112358"
    private boolean verify(String num, int pos, long part1, long part2){
        String part3 = new Long(part1+part2).toString();
        if(pos+part3.length() > num.length()) return false;
        else if(pos+part3.length()==num.length() ){
           boolean eqPart3 = num.substring(pos, pos+part3.length()).equals(part3);
           return eqPart3;
        }
        return verify(num, pos+part3.length(), part2, part1+part2);
    }
}