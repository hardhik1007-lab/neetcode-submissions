class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        pref=1
        prod=1
        res = [1] * len(nums)
        for i in range(len(nums)):
            res[i] = pref
            pref = pref * nums[i]
        for i in range(len(nums)-1, -1,-1):
            res[i] = res[i]*prod
            prod = prod * nums[i]
        return res
        
