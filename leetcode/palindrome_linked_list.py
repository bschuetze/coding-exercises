# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
import math
from typing import Optional


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            # ?
            return False
        if head.next is None:
            return True
        
        # Count elements
        head_iter = head
        num_elems = 1
        while head_iter.next is not None:
            head_iter = head_iter.next
            num_elems += 1

        elems = []
        for i in range(math.floor(num_elems / 2)):
            elems.append(head.val)
            head = head.next

        # Eliminate middle element if exists
        if num_elems % 2 != 0:
            head = head.next

        while head is not None:
            if head.val != elems.pop():
                return False
            head = head.next
        return True



# class Solution:
#     def isPalindrome(self, head: Optional[ListNode]) -> bool:
#         if head is None:
#             # ?
#             return False
#         if head.next is None:
#             return True

#         rev = ListNode(head.val)
#         head_iter = head
#         length = 1
#         while head_iter.next is not None:
#             length += 1
#             head_iter = head_iter.next
#             rev = ListNode(head_iter.val, rev)

#         i = 0
#         while i < math.floor(length / 2):
#             print(head.val, rev.val)
#             if head.val != rev.val:
#                 return False
#             head = head.next
#             rev = rev.next
#             i += 1
            
#         return True

        
test = Solution()

last = ListNode(val=2, next=None)
pal = ListNode(val=1, next=last)
test.isPalindrome(pal)