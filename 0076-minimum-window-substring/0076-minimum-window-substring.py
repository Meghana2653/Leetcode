class Solution(object):
    def minWindow(self, s, t):
        if len(t) > len(s):
            return ""
        
        count = {}
        
        for ch in t:
            count[ch] = count.get(ch, 0) + 1
        
        left = 0
        needed = len(t)
        
        min_len = float('inf')
        start = 0
        
        for right in range(len(s)):
            char = s[right]
            
            if char in count:
                if count[char] > 0:
                    needed -= 1
                count[char] -= 1
            
            while needed == 0:
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    start = left
                
                left_char = s[left]
                
                if left_char in count:
                    count[left_char] += 1
                    if count[left_char] > 0:
                        needed += 1
                
                left += 1
        
        if min_len == float('inf'):
            return ""
        
        return s[start:start + min_len]