class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses];
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            map.add(new ArrayList<>());
        }
        for(int[] pr: prerequisites){
            map.get(pr[0]).add(pr[1]);
        }


        for(int[] pr : prerequisites){
            if (state[pr[0]] == 0 && isLoop(pr[0], map, state)){
                return false;
            }
        }
        return true;
    }

    public boolean isLoop(int i, ArrayList<ArrayList<Integer>> map, int[] state ){
        if(state[i] == 1){
            return true;
        }
        if(state[i] == 2){
            return false;
        }

        state[i] = 1;
        
        for(int pre : map.get(i)){
            if(isLoop(pre, map , state)){
                return true;
            }
        }

        state[i] = 2;
        return false;

    }
}
 