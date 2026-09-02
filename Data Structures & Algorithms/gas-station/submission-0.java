class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasum= 0;
        int costum = 0;
        for(int i = 0; i<gas.length;i++){
            gasum+= gas[i];
            costum+=cost[i];

        }
        if(costum>gasum){
            return -1;
        }
        int total =0;
        int res = 0;
        for(int i = 0; i<gas.length;i++){
            total+= gas[i] - cost[i];

            if(total<0){
                res = i+1;
                total = 0;

            }

        }
        return res;
        
    }
}
