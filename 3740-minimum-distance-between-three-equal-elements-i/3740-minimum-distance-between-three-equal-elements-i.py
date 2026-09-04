class Solution:
    def minimumDistance(self, nums):
        positions = {}
        ans = float('inf')

        for i, num in enumerate(nums):
            if num not in positions:
                positions[num] = []

            positions[num].append(i)

            # We only need the latest 3 occurrences
            if len(positions[num]) >= 3:
                a, b, c = positions[num][-3:]

                distance = abs(a - b) + abs(b - c) + abs(c - a)

                ans = min(ans, distance)

        return -1 if ans == float('inf') else ans