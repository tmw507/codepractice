import java.util.*;

class LinkNode{
	public int val;
	public LinkNode next;

	public LinkNode(){
		val = 0;
		next = null;
	}

	public LinkNode(int val){
		this.val = val;
		next = null;
	}
}

class MyStack{
    public int count;
    public LinkNode head;

    public MyStack(){
        count = 0;
        head = null;
    }

    public void push(int val){
        LinkNode temp = new LinkNode(val);
        count++;
        if(head == null) head = temp;
        else{
        	temp.next = head;
            head = temp;
        }
    }
    public boolean isEmpty(){
    	return head == null;
    }
    public void pop(){
        head = head.next; 
        count--;
    }

    public int size(){
    	return count;
    }

    public int peek(){
    	return head.val;
    }
}

public class PersistentStack{
    private static int count;
    private static MyStack copy(MyStack old){
        MyStack newStack = new MyStack();
        if(old.head == null) return newStack;
        LinkNode temp = old.head;
        LinkNode pre  = null;
        while(temp != null){
        	LinkNode n = new LinkNode(temp.val);
            if(pre == null) newStack.head = pre = n;
            else{
            	pre.next = n;
            	pre = n;
            }
        	temp = temp.next;
        }
        return newStack;
    }
    public static MyStack push(int val, MyStack st){
         MyStack newCopy = copy(st);
         newCopy.push(val);
         count = newCopy.size();
         return newCopy;
    }
    public static MyStack pop(MyStack st){
    	 MyStack newCopy = copy(st);
    	 newCopy.pop();
    	 count = newCopy.size();
    	 return newCopy;
    }

    public static int size(){
    	return count;
    }
    public MyStack empty(){
    	count = 0;
        return new MyStack();
    }
    public int peek(MyStack st){
        return st.peek();
    }

    public static void main(String[] args){
    	PersistentStack st = new PersistentStack();
    	MyStack st0 = st.empty();
    	assert st0.isEmpty();

    	MyStack st1 = st.push(1, st0);
    	assert st0.isEmpty();
    	assert st1.size() == 1;
    	MyStack st2 = st.push(2,st1);
    	assert st1.size() == 1;
    	assert st2.size() == 2;
    	assert (st.peek(st2) == 2);

        MyStack st3 = st.push(3,st2);

    	MyStack st4 = st.pop(st3);
    	assert st4.peek() == 2;
    	assert st3.peek() == 3;
    }
}