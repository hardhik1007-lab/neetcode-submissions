class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l,r =1,max(piles)
        res = 0

        
        while l<=r:
            hours=0
            m = (l+r)//2
            for n in piles:
                hours += (n + m - 1) // m
                
            if hours>h:
                
                l=m+1
            else:
                res= m
                r=m-1
        return res
            
                 