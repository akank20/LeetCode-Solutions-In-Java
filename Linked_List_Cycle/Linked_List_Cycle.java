/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public boolean hasCycle(ListNode head) {
    
        //Solution using fast and slow pointers : Avoid using extra memory
        ListNode slow=head;
        ListNode fast=head;
        
        while( fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            // Check if fast and slow pointer meet due to cycle in LL
            if(slow==fast)
                return true;
        }
        
        return false;   
    }
}
