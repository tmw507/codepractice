/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Hint:

Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
*/
public class Solution {
    
    public String numberToWords(int num) {
        String[] ones =  new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens =  new String[]{ "","","Twenty", "Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] misc = new String[] {"", " Thousand "," Million ", " Billion "};
        
        if(num == 0) return ones[0];
        String strNum = num+"";
        int len = strNum.length();
         
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();
        num2WordUtil(strNum, list, ones, tens);
        for(int i= 0; i<list.size(); i++){
            if("Zero".equals(list.get(i))){
                continue;
            }else{
                sb.append(list.get(i)+misc[list.size()-i-1]);
            }
        }
        return sb.toString().trim();
    }
    
    private void num2WordUtil(String str, ArrayList<String> list, String[] ones, String[] tens){
        int len = str.length();
        if(len <= 3){
            list.add(readOut(str, ones, tens));
        }else{
            String part = readOut(str.substring(len-3), ones, tens);
            num2WordUtil(str.substring(0,len-3), list, ones, tens);
            list.add(part);
        }
    }
    
    private String readOut(String str, String[] ones, String[] tens){
        char[] nums = str.toCharArray();
        if(str.length() == 1){
            return ones[nums[0]-'0'];
        }else if(str.length() == 2){
            if(nums[0] == '0')
               return ones[nums[1] - '0'];
            else if(nums[0] == '1'){
               int val = Integer.parseInt(str);
               return ones[val];
            }else {
                if(nums[1] == '0') return tens[nums[0] - '0'];
                else return tens[nums[0]-'0'] + " "+ ones[nums[1]-'0'];
            }
        }else{
           if(str.charAt(0) == '0') return readOut(str.substring(1), ones, tens);
           else {
               String part = readOut(str.substring(1), ones, tens);
               if(part.equals("Zero")) return ones[nums[0] - '0']+ " Hundred";
               return ones[nums[0] - '0']+ " Hundred "+readOut(str.substring(1), ones, tens);  
               
           }  
        }
    }
}