
import java.util.*;

 /* Definition for singly-linked list. */
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null ) return;
        
        ListNode step1 = head;
        ListNode step2 = head;
        
        while(step2.next != null && step2.next.next != null){
            step1 = step1.next;
            step2 = step2.next.next;
        }
        
        step2 = step1.next;
        step1.next = null;
        
        ListNode L2 = reverse(step2);
        step2.next = null;
        merge(head, L2);
    }
    
    public static ListNode reverse(ListNode head){
        if(head.next == null) return head;
        
        ListNode rhead = reverse(head.next);
        head.next.next = head;
        return rhead;
    } 
    
    public static void merge(ListNode L1, ListNode L2){
        if(L1 == null || L2 == null) return;
        ListNode temp = L1.next;
        L1.next = L2;
        L1 = temp;
        merge(L2, L1);
    }
    public static void main(String[] args){
        ReorderList rl = new ReorderList();

        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        
        rl.reorderList(head);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}