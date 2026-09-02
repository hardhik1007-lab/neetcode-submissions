class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[]result = new int[temperatures.length];
        
        Deque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i<temperatures.length;i++){
            
            while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]){
                    int k = stack.pop()[1];
                    result[k] = i-k;
            }
            stack.push(new int[]{temperatures[i],i});

        }
        return result;

    
    }
}
