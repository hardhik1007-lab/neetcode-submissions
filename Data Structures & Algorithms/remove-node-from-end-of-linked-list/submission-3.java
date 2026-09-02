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

        ListNode cur = head;
        int len = 0;
        
        while(cur != null){
            len++;
            cur = cur.next;
        }

        int target = len - n;
        ListNode node = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        int count = 0;
        while(count < target){
            count++;
            prev= node;
            node = node.next;
        }
        prev.next = node.next;

        return dummy.next;

    }
}
