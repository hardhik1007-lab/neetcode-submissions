class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        //build graph
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            al.add(new ArrayList<>());
        }
        for(int[] e : edges){
            al.get(e[1]).add(e[0]);
            al.get(e[0]).add(e[1]);
        }
        int[] h = new int[n];
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            h[i] = dfs(i, al);
            min = Math.min(min, h[i]);
        }

        for(int i = 0; i < n; i++){
            if(h[i] == min){
                ans.add(i);
            }
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