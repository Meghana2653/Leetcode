import heapq

class Solution:
    def isPossible(self, target):
        
        # If only one element
        if len(target) == 1:
            return target[0] == 1

        total = sum(target)

        # Max heap using negatives
        heap = [-x for x in target]
        heapq.heapify(heap)

        while True:

            largest = -heapq.heappop(heap)
            rest = total - largest

            # Success condition
            if largest == 1 or rest == 1:
                return True

            # Impossible cases
            if rest == 0 or largest < rest or largest % rest == 0:
                return False

            # Previous value
            previous = largest % rest

            # Update sum
            total = rest + previous

            # Push back
            heapq.heappush(heap, -previous)