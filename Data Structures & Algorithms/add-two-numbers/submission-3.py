# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        curl1 = l1
        curl2 = l2
        add = 0
        dummy_head = ListNode(0)
        curr= dummy_head
        while (curl1 or curl2):
            val1 = curl1.val if curl1 else 0
            val2 = curl2.val if curl2 else 0
            if val1 + val2 + add <= 9:
                newval = val1 + val2 + add
                curr.next = ListNode(newval)
                curr = curr.next
                add=0
            else:
                newval = val1 + val2 + add - 10
                curr.next = ListNode(newval)
                curr = curr.next
                add = 1

            if curl1:
                curl1 = curl1.next
            else:
                curl1 = None
            

            if curl2:   
                curl2 = curl2.next
            else:
                curl2 = None
        if add==1:
            curr.next = ListNode(add)
        return dummy_head.next
            


