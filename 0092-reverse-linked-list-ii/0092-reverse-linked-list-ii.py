class Solution(object):
    def reverseBetween(self, head, left, right):
        
        if not head or left == right:
            return head

        dummy = ListNode(0)
        dummy.next = head

        prev = dummy

        # Move prev to node before left position
        for i in range(left - 1):
            prev = prev.next

        current = prev.next

        # Reverse the sublist
        for i in range(right - left):
            temp = current.next
            current.next = temp.next
            temp.next = prev.next
            prev.next = temp

        return dummy.next