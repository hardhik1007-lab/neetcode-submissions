class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
         for(int i = 0; i<=edges.length; i++){
            par[i] = i;
            rank[i] = 1;
         }

         for(int[] edge : edges){
            if(!union(edge[0], edge[1], rank, par)){

                return new int[]{edge[0], edge[1]};

            }
            
         }
         return new int[0];
    }


    public int find(int n, int[] par ){
        int p = par[n];
        if(n != par[n]){
            p = find(par[n], par);
        }

        return p;


    }

    public boolean union(int n1, int n2, int[] rank, int[] par){
        int p1 = find(n1, par);
        int p2 = find(n2, par);

        if(p1 == p2){
            return false;
        }
        if(rank[p1] > rank[p2]){
            par[p2] = par[p1];
            rank[p1] += rank[p2];
        }else{
            par[p1] = par[p2];
            rank[p2] += rank[p1];
        }
        return true;

    }
        
    }

