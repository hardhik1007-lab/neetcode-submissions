# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        rev_head = self.reverse(head)
        
        if n==1:
            rev_head = rev_head.next
            return  self.reverse(rev_head)
        count=1
        prev, curr =None, rev_head
        while count<n:
            prev = curr
            curr = curr.next
            count+=1
        prev.next=curr.next
        return  self.reverse(rev_head)
        

        


    def reverse(self, head):
        prev, curr = None, head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
            
        return prev