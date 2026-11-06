class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int r = bin(arr, x);
        int l = r - 1;

        while(r-l-1 < k){
            if(l < 0){
                r++;
            }else if(r >= arr.length){
                l--;
            }else if(Math.abs(x - arr[r]) < Math.abs(x - arr[l])){
                r++;
            }else{
                l--;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = l+1; i < r; i++){
            res.add(arr[i]);
        }

        return res;


        
    }

    public int bin(int[] arr, int x){
        int l = 0;
        int r = arr.length - 1;

        int idx = -1;
        while(l <= r){
            int m  = l + (r-l)/2;
            if(arr[m] == x){
                idx = m;
                r = m - 1;
            }else if(arr[m] < x){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }

        if(idx == -1){
            idx = l;
        }

        return idx;

        
    }
}