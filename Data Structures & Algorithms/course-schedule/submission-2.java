class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            al.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        
        for(int[] pre : prerequisites){
            al.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int count=0;

        while(!q.isEmpty()){
            int cur = q.poll();
            count++;

            // assume cur is comepleted because no prerequisites.
            // if cur is completed what courses indegree will be decreased by 1.

            for(int pre : al.get(cur)){
                indegree[pre]--;
                if(indegree[pre] == 0){
                    q.offer(pre);
                }
            }
            
            

        }

        return count == numCourses;
    }
}
