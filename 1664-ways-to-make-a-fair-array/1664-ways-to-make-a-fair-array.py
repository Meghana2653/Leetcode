class Solution(object):
    def waysToMakeFair(self, nums):
        totalEven = 0
        totalOdd = 0

        for i in range(len(nums)):
            if i % 2 == 0:
                totalEven += nums[i]
            else:
                totalOdd += nums[i]

        leftEven = 0
        leftOdd = 0
        ans = 0

        for i in range(len(nums)):

            if i % 2 == 0:
                rightEven = totalEven - leftEven - nums[i]
                rightOdd = totalOdd - leftOdd

                newEven = leftEven + rightOdd
                newOdd = leftOdd + rightEven
            else:
                rightEven = totalEven - leftEven
                rightOdd = totalOdd - leftOdd - nums[i]

                newEven = leftEven + rightOdd
                newOdd = leftOdd + rightEven

            if newEven == newOdd:
                ans += 1

            if i % 2 == 0:
                leftEven += nums[i]
            else:
                leftOdd += nums[i]

        return ans