class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
       s1 = {}
       t1 = {}
       if len(s)!=len(t):
        return False

       for i in s:
        
            s1[i]=1+s1.get(i,0)
        

       for i in t:
        
            t1[i]=1+t1.get(i,0)
         

       for c in s1:
            if s1[c] != t1.get(c,0):
                return False
       return True  