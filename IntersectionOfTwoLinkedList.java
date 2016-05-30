/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if(lenA == 0 || lenB == 0) return null;
        if(lenA <= lenB){
            int diff = lenB- lenA, i = 0;
            ListNode startB = headB;
            while(i < diff){
                startB = startB.next;
                i++;
            }
            //reverse listA
            ListNode rHeadA = reverseList(headA);
            
            //make a circle by connecting head A and startB
            headA.next = startB;
            
            //first of all, check whether there is a circle present
            if(!hasCircle(headA)) {
                headA.next = null;
                reverseList(rHeadA);
                return null;
            }
            
            //calc the half lenght of the circle
            int circleLen = getLength(headA);
            int halfLen = circleLen/2;
            i=0;
            
            //go through half length of the circle to get the merge node
            ListNode mergeNode = startB;
            while(i<halfLen){
                mergeNode = mergeNode.next;
                i++;
            }
            
            //broke the circle and restore List A
            headA.next = null;
            reverseList(rHeadA);
            return mergeNode;
        }else{
            return getIntersectionNode(headB, headA);
        }
    }
    
    private int getLength(ListNode list){
        int len = 0;
        if(list == null) return 0;
        
        ListNode temp = list.next;
        len = 1;
        while(temp != null && temp != list){
            temp = temp.next;
            len++;
        }
        return len;
    }
    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    private boolean hasCircle(ListNode head){
        if(head == null) return false;
        ListNode temp = head.next;
        
        while(temp != null && temp != head){
            temp = temp.next;
        }
        return temp == null? false: true;
    }
}