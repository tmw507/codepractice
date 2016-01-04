import java.lang.*;
import java.util.*;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> numList = new LinkedList<Integer>();
        k = k-1;
        for(int i=1; i<=n; i++){
            numList.add(i);
        }
        if(n == 0) return "";
        putNumber(numList, n, k, 0);
        StringBuffer buf = new StringBuffer();
        for(Integer num: numList){
            buf.append(num.toString());
        }
        return buf.toString();
        
    }
    private void putNumber(LinkedList<Integer> numList, int n, int k, int index){
        if(index >= numList.size()) return;
        int facN_1 = fac(n-1);
        int block = k/facN_1;
        k = k % facN_1;
        
        System.out.println("n:"+n+" k:"+k+" index:"+index);

        Integer elem = numList.remove(block+index);
        numList.add(index,elem);
        System.out.println("index:"+index+" elem:"+elem);        
        putNumber(numList, n-1, k, index+1);
        
    }
    private int fac(int n){
        if(n <= 0) return 1;
        return n*fac(n-1);
    }

    public static void main(String[] args){
        PermutationSequence ps = new PermutationSequence();
        String str = ps.getPermutation(4,2);
        System.out.println(str);
    }
}