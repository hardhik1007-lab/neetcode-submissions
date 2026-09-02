import collections
from typing import List

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        if not heights or not heights[0]:
            return []

        rows, cols = len(heights), len(heights[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def bfs(starts):  # Only one parameter here
            visit = set()
            q = collections.deque(starts)
            for r, c in starts:
                visit.add((r, c))

            while q:
                row, col = q.popleft()
                for dr, dc in directions:
                    r1, c1 = row + dr, col + dc
                    if (
                        0 <= r1 < rows and 0 <= c1 < cols and
                        (r1, c1) not in visit and
                        heights[r1][c1] >= heights[row][col]
                    ):
                        visit.add((r1, c1))
                        q.append((r1, c1))
            return visit

        pacific_starts = [(0, c) for c in range(cols)] + [(r, 0) for r in range(rows)]
        atlantic_starts = [(rows - 1, c) for c in range(cols)] + [(r, cols - 1) for r in range(rows)]

        pacific_reachable = bfs(pacific_starts)
        atlantic_reachable = bfs(atlantic_starts)

        result = list(pacific_reachable & atlantic_reachable)
        return result
