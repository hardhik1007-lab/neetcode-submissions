class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<position.length;i++){
            map.put(position[i],speed[i]);
        }
        Deque<Double> stack = new ArrayDeque<>();
        
        Arrays.sort(position);

        for(int i =position.length-1;i>=0;i--){
            if(stack.isEmpty()){
                double time = (double)(target -  position[i])/map.get(position[i]);
                stack.push(time);
            }else{
                double time = (double)(target -  position[i])/map.get(position[i]);
                double top = stack.peek();
                if(time>top){
                    stack.push(time);

                }
            }
            
        }
        return stack.size();




        
    }
}
