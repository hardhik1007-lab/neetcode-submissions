class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res=0
        strs=""
        i=0
        while i<len(s):
            if s[i] not in strs:
                strs+=(s[i])
                res= max(res,len(strs))
                i+=1
                
            else:
                ind= strs.index(s[i])
                strs=strs[ind+1:]+s[i]
                i+=1
                

            
        return res
                

