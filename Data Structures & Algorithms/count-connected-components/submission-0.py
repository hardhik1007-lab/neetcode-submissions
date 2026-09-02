class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        
        visit= set()
        adj = {i: [] for i in range(n)}

        for i, j in edges:
            adj[i].append(j)
            adj[j].append(i)
        
        res=0

        def dfs(node):
            for nei in adj[node]:
                if nei not in visit:
                    visit.add(nei)
                    dfs(nei)


        
        for i in range(n):
            if i not in visit:
                visit.add(i)
                dfs(i)
                res+=1
        
                
                
                
        return res
