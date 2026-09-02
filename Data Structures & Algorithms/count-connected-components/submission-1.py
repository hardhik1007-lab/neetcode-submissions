class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        par = [i for i in range(n)]
        rank = [1] * n

        def find(n1):
            res = n1
            while res !=par[res]:
                res= par[res]

            return res
        def union(n1,n2):
            p1,p2 = find(n1),find(n2)

            if p1==p2:
                return 0
            else:
                if rank[p2]>rank[p1]:
                    par[p1] = p2
                    rank[p2]+=rank[p1]
                else:
                    par[p2]=p1
                    rank[p1]+=rank[p2]
                return 1
        ans = n
        for i,j in edges:
            ans = ans - union(i,j)
        return ans

