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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0, head);
        
        ListNode cur = head;
        ListNode tail = dummy;
        
        
        

        while(cur != null){

            // check if there are k nodes
            int count = 0;
            ListNode check =  cur;
            while(check != null && count < k){
                check = check.next;
                count++;
            }
            if(count < k){
                break;
            }

            count = 0;

            ListNode groupHead = cur;
            ListNode prev = null;

             
            while(count < k){
                ListNode temp = cur.next;
                cur.next = prev;
                prev= cur;
                cur= temp;
                count++;
            }
            tail.next = prev;
            groupHead.next = cur;
            tail = groupHead; 



        }
        return dummy.next;
    }
}
