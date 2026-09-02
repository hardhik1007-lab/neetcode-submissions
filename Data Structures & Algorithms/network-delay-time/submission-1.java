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

        List<int[]> k_neigh = adjacency.get(k);
        Queue<Integer> q = new ArrayDeque<>();

        q.add(k);
        

        while(!q.isEmpty()){
            int cur = q.poll();
            List<int[]> cur_N = adjacency.get(cur);

            for(int i = 0; i < cur_N.size(); i++){
                int[] neighbor = cur_N.get(i);
                int node=  neighbor[0];
                int time= neighbor[1];
                if(shortest[cur] + time < shortest[node]){
                    shortest[node] = shortest[cur] + time;
                    q.offer(node);
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
