class Solution(object):
    def getPermutation(self, n, k):
        numbers = [str(i) for i in range(1, n + 1)]
        
        fact = 1
        for i in range(1, n):
            fact *= i

        k -= 1
        result = []

        for i in range(n, 0, -1):
            index = k // fact
            result.append(numbers.pop(index))

            k %= fact

            if i > 1:
                fact //= (i - 1)

        return "".join(result)