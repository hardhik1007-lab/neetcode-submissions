class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[][] start = new int[trips.length][2];
        int[][] end = new int[trips.length][2];

        for(int i = 0; i < trips.length; i++){
            start[i][0] = trips[i][1];
            start[i][1] = trips[i][0];

            end[i][0] = trips[i][2];
            end[i][1] = trips[i][0];
        } 
        Arrays.sort(start, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(end, (a,b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int i = 0;
         int j = 0;

        while(i < start.length){
            while(j < end.length && end[j][0] <= start[i][0]){
                count -= end[j][1];
                j++;
            }
            count += start[i][1];
            i++;

            if(count > capacity){
                return false;
            }
        }

        return true;

        
    }
}