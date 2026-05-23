class Solution(object):
    def licenseKeyFormatting(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        
        # Remove dashes and convert to uppercase
        s = s.replace("-", "").upper()
        
        result = []
        
        # Process characters from the end
        while len(s) > k:
            result.append(s[-k:])
            s = s[:-k]
        
        # Add remaining part
        result.append(s)
        
        # Reverse and join with dashes
        return "-".join(result[::-1])