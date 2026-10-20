class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<List<Integer>> al = new ArrayList<>();
        List<Boolean> res = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            al.add(new ArrayList<>());
        }

        // build graph with course --> prerequisite
        for(int[] pre : prerequisites){
            al.get(pre[1]).add(pre[0]);
        }


        // queries prerequisite q[0] --> course q[1]
        for(int[] q : queries){
            Queue<Integer> que = new ArrayDeque<>();
            HashSet<Integer> visited = new HashSet<>();

            que.offer(q[1]);
            visited.add(q[1]);
            boolean found = false;

            while(!que.isEmpty()){
                int cur = que.poll();
                if(cur == q[0]){
                    res.add(true);
                    found = true;
                    break;
                }else{

                    List<Integer> x = al.get(cur);
                    for(int j = 0; j < x.size(); j++){
                        if(!visited.contains(x.get(j))){
                            que.add(x.get(j));
                            visited.add(x.get(j));
                        }
                    }
                }
            }

            if(!found){
                res.add(false);
            }

        }

        return res;


        
    }
}