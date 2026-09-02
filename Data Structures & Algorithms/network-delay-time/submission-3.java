class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adjacency  = new ArrayList<>();
        int[] shortest = new int[n+1];
        for(int i = 1; i < n+1; i++){
            if(i != k){
                shortest[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }   

        for(int[] time : times){
            adjacency.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        minHeap.offer(new int[]{k,0});
        

        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            if(shortest[cur[0]] < cur[1]){
                continue;
            }
            shortest[cur[0]] = cur[1]; 
            
            List<int[]> cur_N = adjacency.get(cur[0]);

            for(int i = 0; i < cur_N.size(); i++){
                int[] neighbor = cur_N.get(i);
                int node=  neighbor[0];
                int weight= neighbor[1];
                if(weight + cur[1] < shortest[node]){
                    shortest[node] = weight + cur[1];
                    minHeap.offer(new int[]{node, weight + cur[1]});
                }
                
            }

        }

        int max= 0;
        for(int i = 1; i < shortest.length; i++){
            if(shortest[i] == Integer.MAX_VALUE){
                return -1;
            }else{
                max= Math.max(max, shortest[i]);
            }
        }

        return max;

        

        
        
    }
}
