class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        visit = set()

        adj = {i: [] for i in range(n)}

        for i,j in edges:
            adj[i].append(j)
            adj[j].append(i)
        
        prev=-1
        
        def dfs(node,prev):
            if node in visit:
                return False

            visit.add(node)

            
            
            
            for nei in adj[node]:
                if nei == prev:
                    continue
                if not dfs(nei, node):
                    return False
            return True
            
        
            
            
        

        return dfs(0,-1) and len(visit) == n

                

            
            


