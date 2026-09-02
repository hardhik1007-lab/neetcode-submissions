# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        s = head
        fast = head.next
        while fast and fast.next:
            fast = fast.next.next 
            s = s.next 
        
        list2 = self.reverse(s.next)
        s.next = None
        while list2:
            tmp1, tmp2 = head.next, list2.next
            head.next = list2
            list2.next = tmp1
            head = tmp1
            list2 = tmp2 
            




    def reverse(self, head):

        prev, curr = None, head

        while curr:
            nxt = curr.next
            curr.next = prev
            prev= curr
            curr = nxt 
        return prev

    

