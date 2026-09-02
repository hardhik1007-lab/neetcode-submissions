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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        ListNode prev = new ListNode(0);
        ListNode tail = prev;

        while(cur1 != null || cur2 != null){

            int val1 = cur1 != null ? cur1.val : 0;
            int val2 = cur2 != null ? cur2.val : 0;
            int sum = val1 + val2 + carry;
            
            carry = sum / 10; 
            sum = sum % 10;
            
            ListNode node= new ListNode(sum);
            tail.next = node;
            tail = node;
            cur1 = cur1 != null ? cur1.next : null;
            cur2 = cur2 != null ? cur2.next : null;
        }
        if(carry != 0){
            ListNode end = new ListNode(carry);
            tail.next = end;
        }

        return prev.next;
        
    }
}
