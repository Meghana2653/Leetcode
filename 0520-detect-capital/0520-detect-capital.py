class Solution(object):
    def detectCapitalUse(self, word):
        
        # All letters are uppercase
        if word.isupper():
            return True
        
        # All letters are lowercase
        if word.islower():
            return True
        
        # Only first letter is uppercase
        if word.istitle():
            return True
        
        return False