class Solution(object):
    def pivotInteger(self, n):
        total = n * (n + 1) // 2

        prefix = 0
        for x in range(1, n + 1):
            prefix += x
            if prefix == total - prefix + x:
                return x

        return -1