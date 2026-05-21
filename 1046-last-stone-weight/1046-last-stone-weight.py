import heapq

class Solution:
    def lastStoneWeight(self, stones):
        
        # Convert to max heap using negative values
        stones = [-stone for stone in stones]
        heapq.heapify(stones)

        while len(stones) > 1:
            
            # Take two heaviest stones
            first = -heapq.heappop(stones)
            second = -heapq.heappop(stones)

            # If not equal, push the difference
            if first != second:
                heapq.heappush(stones, -(first - second))

        # Return remaining stone or 0
        return -stones[0] if stones else 0