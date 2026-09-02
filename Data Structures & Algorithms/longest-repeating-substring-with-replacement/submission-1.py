class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        res=0 
        dic={}
        l=0
        r=0
        for r in range(len(s)):
            dic[s[r]] = 1+dic.get(s[r],0)

            while (r-l+1) - max(dic.values())>k:
                dic[s[l]]-=1
                l+=1
            res = max(res, r-l+1)
        return res

