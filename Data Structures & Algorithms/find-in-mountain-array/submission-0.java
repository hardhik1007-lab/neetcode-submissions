/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int length = mountainArr.length();

        int l = 0;
        int r = length - 1;
        //find peak

        while(l < r){
            int m = l + (r-l)/2;

            if(mountainArr.get(m) > mountainArr.get(m+1)){
                r = m;
            }else{
                l = m + 1;
            }
        }

        int peak_index  = l;
        int peak_element = mountainArr.get(l);

        if(peak_element == target){
            return peak_index;
        }

        // first uphill

        l = 0;
        r =  peak_index;

        while(l <= r){
            int m = l + (r - l) / 2;

            int middle = mountainArr.get(m);

            if( middle == target){
                return m;
            }else if(middle > target){
                r = m - 1;
            }else{
                l = m + 1;
            }

        }

        //if didnt find it, means check downhill
        l = peak_index;
        r = length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;

            int middle = mountainArr.get(m);

            if( middle == target){
                return m;
            }else if(middle > target){
                l = m + 1;
                
            }else{
                r = m - 1;
            }

        }

        //if nothing return -1
        return -1;




        
    }
}