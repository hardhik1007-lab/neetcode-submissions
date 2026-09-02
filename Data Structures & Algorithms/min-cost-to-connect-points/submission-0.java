class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        HashSet<Integer> visited = new HashSet<>();
        minheap.offer(new int[]{0,0});
        int cost = 0;

        while(visited.size() < points.length){
            int[] cur = minheap.poll();
            if(visited.contains(cur[0])){
                continue;
            }
            visited.add(cur[0]);
            cost += cur[1];
            for(int i = 0; i < points.length; i++){
                if(!visited.contains(i)){
                    int distance = Math.abs(points[cur[0]][0] - points[i][0]) + Math.abs(points[cur[0]][1] - points[i][1]);

                    minheap.offer(new int[]{i, distance});
                }
            }
        }

        return cost;
        
    }
}
