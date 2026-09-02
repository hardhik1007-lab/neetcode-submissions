class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(newInterval[1]<intervals[i][0]){
                res.add(newInterval);
                for(int j = i; j<n; j++){
                    res.add(intervals[j]);
                } 
                return res.toArray(new int[res.size()][]);
            }else if(newInterval[0]>intervals[i][1]){
                res.add(intervals[i]);
            }else{
                newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]),Math.max(intervals[i][1], newInterval[1])};
                
            }
            
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);

        
    }
}
