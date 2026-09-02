class Solution {
    
    public int minCostConnectPoints(int[][] points) {
        int[] parent= new int[points.length];
        int[] size = new int[points.length];

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        
        for(int i = 0; i < points.length; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                minheap.offer(new int[]{distance, i , j});
            }
        }

        int cost = 0;
        int count = 0;

        while(count < points.length - 1){
            int[] cur = minheap.poll();
        
            int rootv = find(cur[1],parent);
            int rootu = find(cur[2],parent);

            if(rootv != rootu){
                count++;
                cost += cur[0];
                if(size[rootv] > size[rootu]){
                    parent[rootu] = rootv;
                    size[rootv] += size[rootu];
                }else{
                    parent[rootv] = rootu;
                    size[rootu] += size[rootv];
                }
            }

        }
        return cost;
        
    }

    public int find(int u, int[] parent){
        if(parent[u] != u){
            parent[u] = find(parent[u], parent);
            
        }
        return parent[u];
    }
}
