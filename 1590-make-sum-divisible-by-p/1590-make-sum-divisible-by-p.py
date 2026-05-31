class Solution:
    def minSubarray(self, nums, p):
        total_rem = sum(nums) % p

        if total_rem == 0:
            return 0

        prefix = 0
        ans = len(nums)

        seen = {0: -1}

        for i, num in enumerate(nums):
            prefix = (prefix + num) % p

            target = (prefix - total_rem) % p

            if target in seen:
                ans = min(ans, i - seen[target])

            seen[prefix] = i

        return ans if ans < len(nums) else -1