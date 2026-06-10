class Solution(object):
    def selfDividingNumbers(self, left, right):
        ans = []

        for num in range(left, right + 1):
            x = num
            valid = True

            while x:
                digit = x % 10

                if digit == 0 or num % digit != 0:
                    valid = False
                    break

                x //= 10

            if valid:
                ans.append(num)

        return ans