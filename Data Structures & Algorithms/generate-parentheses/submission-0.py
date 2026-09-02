class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        stack = []
        res = []

        def dfs(openN, close):
            if openN==close==n:
                res.append("".join(stack))
                return 
            
            if openN<n:
                stack.append("(")
                dfs(openN+1,close)
                stack.pop()
            
            if close<openN:
                stack.append(')')
                dfs(openN,close+1)
                stack.pop()

        dfs(0,0)
        return res
        
