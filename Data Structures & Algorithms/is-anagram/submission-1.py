class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
       s1 = {}
       t1 = {}
       if len(s)!=len(t):
        return False

       for i in range(len(s)):
        
            s1[s[i]]=1+s1.get(s[i],0)
            t1[t[i]]=1+t1.get(t[i],0)
       for c in s1:
            if s1[c] != t1.get(c,0):
                return False
       return True  