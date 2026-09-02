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
    public void reorderList(ListNode head) {

        //find the middle point;
        ListNode i= head;
        ListNode j = head.next;
        while(j != null && j.next != null){
            i = i.next;
            j = j.next.next;
        }

        //reverse from i;
        ListNode half2 = i.next;
        ListNode prev = null;
        i.next = prev;
        

        while(half2 != null){
            ListNode next = half2.next;
            half2.next = prev;
            prev = half2;
            half2= next;
        }
        
        ListNode half1 = head;
        half2 = prev;
        while(half2 != null){
            ListNode next1 = half1.next;
            ListNode next2 = half2.next;
            half1.next = half2;
            half2.next = next1;
            half1 = next1;
            half2 = next2;
        }
        


        

        
    }
}
