/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode curr1 = head;
        while(cur.next!=null){
            len++;
            cur=cur.next;
        }

        int node = len-n+1;
        int count = 1;
        ListNode prev = dummy;
        while(curr1!=null){
            if(count == node){
                
                prev.next = curr1.next;

            }
            count++;
            prev = curr1;
            curr1= curr1.next;
            
        }
        return dummy.next;



            
         


    }
}
