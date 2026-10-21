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

        List<Set<Integer>> preall = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            preall.add(null);
        }

        for(int i = 0; i < numCourses; i++){
            dfs(i, preall, al);
        }

        for(int[] q : queries){
            Set<Integer> s = preall.get(q[1]);
            res.add(s.contains(q[0]));
        }

        return res;
    }


    public Set<Integer> dfs(int course, List<Set<Integer>> preall, List<List<Integer>> al){
        if(preall.get(course) != null){
            return preall.get(course);
        }
        
        Set<Integer> f = new HashSet<>();

        List<Integer> cur = al.get(course);
        for(int i = 0; i < cur.size(); i++){
            //recursively get everything.
            f.add(cur.get(i));
            Set<Integer> child = dfs(cur.get(i), preall, al);
            f.addAll(child);

        }

        preall.set(course,f);//the full list calculated

        return f;

    }
}