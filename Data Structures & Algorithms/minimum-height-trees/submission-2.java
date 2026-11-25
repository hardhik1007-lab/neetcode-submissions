class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n == 1){
            return List.of(0);
        }

        //build graph and indegree
        List<List<Integer>> al = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            al.add(new ArrayList<>());
        }
        for(int[] e : edges){
            al.get(e[1]).add(e[0]);
            al.get(e[0]).add(e[1]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();

        int rem = n;

        for(int i = 0; i < n; i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }

        while(rem > 2){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int cur = q.poll();
                rem--;
                List<Integer> li = al.get(cur);
                for(int x : li){
                    indegree[x]--;
                    if(indegree[x] == 1){
                        q.add(x);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int s = q.size();
        for(int i = 0; i < s; i++){
            ans.add(q.poll());
        }
        

        return ans;


        
    }

    public int dfs(int root, List<List<Integer>> al){
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(root);
        set.add(root);
        int res = -1;
        

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                for(int n : al.get(cur)){
                    if(!set.contains(n)){
                        q.offer(n);
                        set.add(n);
                    }
                }
            }

            res++;
            
        }

        return res;
    }
}