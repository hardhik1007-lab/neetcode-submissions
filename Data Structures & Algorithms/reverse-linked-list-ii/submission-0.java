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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode cur = head;
        int count = 1;
        ListNode prev = null;
        

        ListNode leftnode = null;
        ListNode lefttail = null;
        ListNode rightnode = null;
        ListNode righthead = null;



        while(cur != null){
            if(count == left){
                leftnode = cur;
                lefttail = prev;

            }
            if(count == right){
                rightnode = cur;
                righthead = cur.next;
            }

            prev = cur;
            cur = cur.next;
            
            count++;

        }

        ListNode prev1 = null;
        cur = leftnode;

        while(cur != righthead){
            ListNode next = cur.next;
            cur.next = prev1;
            prev1 = cur;
            cur = next;
        }

        if(lefttail == null){
            head = prev1;
        }else{
            lefttail.next = prev1;
        }

        leftnode.next = righthead;

        return head;

        
    }
}