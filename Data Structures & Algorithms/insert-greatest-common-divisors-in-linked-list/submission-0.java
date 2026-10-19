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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode prev = head;
        ListNode next = head.next;

        while(next != null){
            int gcd = gcd(prev.val, next.val);
            ListNode node = new ListNode(gcd);
            prev.next = node;
            node.next = next;

            prev = node.next;
            next = next.next;
        }

        return head;


    }
    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}