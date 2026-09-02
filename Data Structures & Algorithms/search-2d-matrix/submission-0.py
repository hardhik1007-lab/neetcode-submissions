class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l = 0
        r = len(matrix) - 1
        array = -1
        while l<=r:
            m = l + (r-l)//2
            if matrix[m][0]==target or matrix[m][len(matrix[m])-1]==target:
                return True
            elif matrix[m][0]<target and matrix[m][len(matrix[m])-1]>target:
                array = m
                break
            elif target > matrix[m][len(matrix[m])-1]:
                l = m+1
            else:
                r=m-1
        if array==-1:
            return False
        
            
        res_list = matrix[array]
        l1=0
        r1 = len(res_list) -1
        
        while l1<=r1:
            m1 = l1 + (r1-l1)//2
            if res_list[m1]==target:
                return True
            elif res_list[m1]>target:
                r1 = m1-1
            else:
                l1 = m1+1
    
        return False
        
            

