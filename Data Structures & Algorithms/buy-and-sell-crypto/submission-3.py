class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l,r = 0,1
        res=0
        while r<len(prices):
            res = max(res,prices[r]-prices[l])
            if prices[r]-prices[l]<0:
                l=r
            r+=1
                
            

        return res