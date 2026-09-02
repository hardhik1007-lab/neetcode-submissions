class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Deque<int[]> stack = new ArrayDeque<>();

        
        for(int i = 0; i< temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i]>stack.peek()[0]){
                int[] cur = stack.pop();
                
                res[cur[1]] = i - cur[1];

            }
            stack.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}
