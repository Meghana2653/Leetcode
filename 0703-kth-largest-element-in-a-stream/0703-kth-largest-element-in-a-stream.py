# class KthLargest(object):

#     def __init__(self, k, nums):
#         """
#         :type k: int
#         :type nums: List[int]
#         """
        

#     def add(self, val):
#         """
#         :type val: int
#         :rtype: int
#         """
        
import heapq

class KthLargest:

    def __init__(self, k, nums):
        self.k = k
        self.heap = []

        for num in nums:
            heapq.heappush(self.heap, num)

            if len(self.heap) > k:
                heapq.heappop(self.heap)

    def add(self, val):
        heapq.heappush(self.heap, val)

        if len(self.heap) > self.k:
            heapq.heappop(self.heap)

        return self.heap[0]

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)