class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows, cols = len(heights), len(heights[0])


        def bfs(starts):
            
            q = collections.deque(starts)
            visit=set(starts)
            directions = [[1,0],[-1,0],[0,1],[0,-1]]
            
            while q:
                row,col = q.popleft()
                for dr,dc in directions:
                    r1,c1 = dr+row , col + dc
                    if (r1 in range(rows) and c1 in range(cols) and heights[row][col] <= heights[r1][c1]
                        and (r1,c1) not in visit):
                        visit.add((r1,c1))
                        q.append((r1,c1))
            return visit


        pacific_starts = [(0,c) for c in range(cols)] + [(r,0)for r in range(rows)]
        atlantic_starts = [(rows-1,c) for c in range(cols)] + [(r,cols-1) for r in range(rows)]
        pacific_ways= bfs(pacific_starts)
        atlantic_ways = bfs(atlantic_starts)
        res = list(pacific_ways & atlantic_ways)
        return res

                    

