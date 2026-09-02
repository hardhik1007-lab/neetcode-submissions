class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prod=1
        res=[]
        
        count_0=0
        for i in nums:
            if i==0:
                count_0+=1
                
                continue
            prod *=i
        if count_0>1:
            res=[0]*len(nums)
            return res
        for i in nums:
            if count_0==1:
                if i==0:
                    res.append(prod)
                    continue
                else:
                    res.append(0)
            else:
                res.append(int(prod/i))
        return res
