class Solution(object):
    def rotateString(self, s, goal):
        """
        :type s: str
        :type goal: str
        :rtype: bool
        """

        # Lengths must be same
        if len(s) != len(goal):
            return False

        # Check rotation
        return goal in (s + s)
        