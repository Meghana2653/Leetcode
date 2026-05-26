class Solution(object):
    def repeatedSubstringPattern(self, s):
        """
        :type s: str
        :rtype: bool
        """
        
        n = len(s)

        for i in range(1, n // 2 + 1):
            
            # substring length must divide total length
            if n % i == 0:
                
                sub = s[:i]
                
                # repeat substring
                if sub * (n // i) == s:
                    return True

        return False