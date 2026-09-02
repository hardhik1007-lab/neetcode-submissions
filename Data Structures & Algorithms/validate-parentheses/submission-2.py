class Solution:
    def isValid(self, s: str) -> bool:
        if len(s)%2 ==1:
            return False
        closeToOpen = { ")" : "(", "]" : "[", "}" : "{" }
        stack = []
        for ch in s:
            if ch in closeToOpen.values():
                stack.append(ch)
            elif ch in closeToOpen:
                if not stack or closeToOpen[ch] != stack[-1]:
                    return False
                stack.pop()
        return True if not stack else False
                
                
                    

        




