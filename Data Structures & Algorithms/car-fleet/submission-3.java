class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<position.length;i++){
            map.put(position[i],speed[i]);
        }
        
        int fleet = 1;
        int n = position.length-1;
        
        Arrays.sort(position);
        double prevTime =(double) (target - position[n])/map.get(position[n]);

        for(int i =position.length-1;i>=0;i--){
            double currTime = (double)(target - position[i]) / map.get(position[i]);
            if(currTime>prevTime){
                fleet++;
                prevTime = currTime;
            }

            
        }
        return fleet;




        
    }
}
