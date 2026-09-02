class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        find ={}
        for i in range(len(nums)):
            if (target-nums[i]) in find:
                return [find[target-nums[i]],i]
            else:
                find[nums[i]]=i