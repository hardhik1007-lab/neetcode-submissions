class Solution {
    public int maxTurbulenceSize(int[] arr) {

        if(arr.length == 1){
            return 1;
        }

        if(arr.length == 2){
            if(arr[0] == arr[1]){
                return 1;
            }else{
                return 2;
            }
        }

        int prev = arr[0] - arr[1];
        int curmax = 2;
        int max = 0;

        for(int i = 1; i < arr.length - 1; i++){
            int cur = arr[i] - arr[i+1];

            if((prev < 0 && cur > 0 ) || (prev > 0 && cur < 0)){
                curmax++;
                
            }else if((prev < 0 && cur < 0) || (prev > 0 && cur > 0)){
                curmax = 2;
                
            }else{
                if(cur == 0){
                    curmax = 1;
                }else{
                    curmax = 2;
                }
            }

            prev =cur;

            max = Math.max(max, curmax);
        }

        return max;
        
    }
}