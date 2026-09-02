class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows,cols = len(board),len(board[0])
        path=set()
        def dfs(x,r,c):
            if x == len(word):
                return True
            if (r<0 or c<0  or r>=rows or c>=cols or  word[x] != board[r][c] or (r,c) in path):
                return False
            
            path.add((r,c))
            res= ( dfs(x+1,r+1,c) or 
                    dfs(x+1,r-1,c ) or
                    dfs(x+1,r,c+1 ) or
                    dfs(x+1,r,c-1 )) 
            path.remove((r,c))
            return res




        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(0,i,j): return True
        return False

