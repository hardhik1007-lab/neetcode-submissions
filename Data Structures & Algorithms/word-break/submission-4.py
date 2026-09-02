class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s)+1)
        dp[0]= True

        for i in range(len(s)):
            if dp[i]:
                for word in wordDict:
                    if i+len(word)<=len(s) and s[i:i+len(word)] == word:
                        dp[i+len(word)]= True
                        
        return dp[len(s)]