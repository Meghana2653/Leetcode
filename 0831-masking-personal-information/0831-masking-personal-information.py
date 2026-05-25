class Solution(object):
    def maskPII(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        # Check if it is an email
        if '@' in s:
            s = s.lower()
            name, domain = s.split('@')
            
            # Keep first and last character, mask middle
            return name[0] + "*****" + name[-1] + "@" + domain
        
        else:
            # Extract only digits
            digits = []
            for ch in s:
                if ch.isdigit():
                    digits.append(ch)
            
            digits = "".join(digits)
            
            # Last 4 digits
            local = "***-***-" + digits[-4:]
            
            # Country code length
            country_len = len(digits) - 10
            
            if country_len == 0:
                return local
            else:
                return "+" + "*" * country_len + "-" + local