public class Solution {
    class Status{
        public int val;
        public int p;
        
        public Status(int val, int p){
            this.val = val;
            this.p = p;
        }
        
    }
    public int compareVersion(String version1, String version2) {
        
        char[] str1 = version1.toCharArray();
        char[] str2 = version2.toCharArray();
        int p1=0, p2 =0;
        
        while(true){
        
            Status s1 = extract(str1,p1);
            Status s2 = extract(str2,p2);
            p1 = s1.p+1;
            p2 = s2.p+1;
            //System.out.println(p1+" "+p2);
            if(s1.val < s2.val) return -1;
            else if(s1.val> s2.val) return 1;
            
            if(p1>=str1.length || p2 >= str2.length) break;
        }
        
        if(p1 < str1.length){
            return compareVersion(version1.substring(p1), new String("0"));
        }else if(p2 < str2.length){
            return compareVersion(new String("0"),version2.substring(p2));
        }else
            return 0;
        
    }
    private Status extract(char[] array, int p){
        int v = 0;
        while( p<array.length && array[p] != '.'){
                v = v*10+array[p]-'0';
                p++;
        }
        //System.out.println("value:"+v+" pos:"+p);
        return new Status(v,p);
    }
}
