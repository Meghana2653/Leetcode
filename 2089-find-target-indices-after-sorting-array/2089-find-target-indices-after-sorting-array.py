class Solution(object):
    def targetIndices(self, nums, target):

        nums.sort()
        indices = []

        for i in range(len(nums)):
            if nums[i] == target:
                indices.append(i)

        return indices