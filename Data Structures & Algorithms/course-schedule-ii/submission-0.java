class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int counter = 0;
        int[] ans = new int[numCourses];
        int[] ansInd = new int[1];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int parent = pre[1];
            int child = pre[0];
            graph.get(parent).add(child);
            indegree[child]++;
        }

        for(int i =0; i< indegree.length;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
            
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            ans[ansInd[0]] = cur;
            ansInd[0]++;
            counter++;

            for(int course : graph.get(cur)){
                indegree[course]--;
                if(indegree[course] == 0){
                    q.offer(course);
                }
            }
        }

        if(counter!=numCourses){
            return new int[0];
        }

        return ans;



        
    }
}
 