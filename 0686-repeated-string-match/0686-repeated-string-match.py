class Solution(object):
    def repeatedStringMatch(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: int
        """

        repeated = a
        count = 1

        # Repeat until length becomes at least length of b
        while len(repeated) < len(b):
            repeated += a
            count += 1

        # Check current repeated string
        if b in repeated:
            return count

        # Check one extra repetition
        repeated += a
        count += 1

        if b in repeated:
            return count

        return -1