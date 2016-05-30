public class Solution {
    public List<String> addOperators(String num, int target) {
        ArrayList<String> list = new ArrayList<String>();
        if(num == null || num.length() < 1) return list;
        StringBuilder sb = new StringBuilder();
        expressionExplore(list, sb, num, 0, target, 0, 0);
        Collections.sort(list);
        return list;
    }
    
    //product: product by applying the multiplication up to old cur item.
    private void expressionExplore(ArrayList<String> list, StringBuilder sb, String num, int start, int target, long pre, long product){
        if(start == num.length() && pre == target){
            list.add(sb.toString());
            return;
        }
        
        for(int i=start; i<num.length(); i++){
            //don't need to further explore due to a bad parsing:  e.g. 01 
            if(num.charAt(start) == '0' && i > start) break; 
            long cur = Long.parseLong(num.substring(start, i+1));
            int len = sb.length();
            
            if(start == 0){
                expressionExplore(list, sb.append(cur), num, i+1, target, cur, cur);
                sb.setLength(len);
            }else{
                
                sb.append("+").append(cur);
                expressionExplore(list, sb, num, i+1, target, pre+cur, cur);
                sb.setLength(len); // backtracking
                
                sb.append("-").append(cur);
                expressionExplore(list, sb, num, i+1, target, pre-cur, -cur);
                sb.setLength(len); // backtracking
                
                sb.append("*").append(cur);
                expressionExplore(list, sb, num, i+1, target, pre-product+product*cur, product*cur);
                sb.setLength(len);
                
            }
        }
    }
}