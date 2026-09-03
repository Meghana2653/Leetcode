class Solution:
    def uniformArray(self, nums1):
        hasOdd = False
        hasEven = False

        minOdd = float('inf')
        minEven = float('inf')

        for num in nums1:
            if num % 2 == 0:
                hasEven = True
                minEven = min(minEven, num)
            else:
                hasOdd = True
                minOdd = min(minOdd, num)

        if not hasOdd:
            return True

        if not hasEven:
            return True

        return minOdd < minEven 