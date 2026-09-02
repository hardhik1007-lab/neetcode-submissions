class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t=="": return ""
        dic_t, window = {}, {}

        for i in t:
            dic_t[i] = 1 + dic_t.get(i,0)

        have, want = 0, len(dic_t)
        res, resLen = [-1,-1], float("infinity")
        l = 0

        for r in range(len(s)):
            c=s[r]
            
            window[c] = 1+window.get(c,0)
            if c in dic_t and window[c]==dic_t[c]:
                have+=1
            
            while have==want:
                if r-l+1 < resLen:
                    res = [l,r]
                    resLen = r-l+1
                window[s[l]]-=1
                if s[l] in dic_t and window[s[l]]<dic_t[s[l]]:
                    have-=1
                l+=1
        l,r = res
        return s[l:r+1] if resLen != float("infinity") else ""

            




        