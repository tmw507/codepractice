// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.



//Input: x = 20 Output: 0 1 2 3 4 5 6 7 8 9 10 12

//Input: x = 105 Output: 0 1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98 101

import java.util.*;

public class NeighborDigit{

    
public void getNeighborNums(int n){
    Queue<Integer> Q = new LinkedList();
    if(n < 0) return;
    if(n <=9){
        for(int i=0; i< n; i++){
            System.out.println(i);
        }
    }else{
        for(int i=0; i<=9; i++){
            Q.add(i);
        }
        System.out.println(Q.poll());
        
        while(Q.size() > 0){
            int num = Q.poll();
            System.out.println(num);
            expand(Q, num, n);
        }
    }   
}

private void expand(Queue<Integer> Q, int num, int n){ 
    
    int lastDigit = num % 10;
    
    if(lastDigit == 0){
        int temp = num*10+1;
        if(temp < n) Q.add(temp);
    }else if(lastDigit == 9){
        int temp = num*10 + 8;
        if(temp < n) Q.add(temp);
    }else{// 1... 8
        int temp = num*10 + (lastDigit-1);
        if(temp < n) Q.add(temp);
        
        temp = num*10 + (lastDigit+1);
        if(temp < n) Q.add(temp);
    }
}
    
    public static void main(String[] args){
        int n = 105;
        NeighborDigit nd = new NeighborDigit();
        nd.getNeighborNums(n);
    }
}

