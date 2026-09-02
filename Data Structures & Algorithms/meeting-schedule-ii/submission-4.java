/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0){return 0;}
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start,b.start));

        int[] start  = new int[intervals.size()];
        int[] end  = new int[intervals.size()];

        

        for(int i = 0; i< intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i]   = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0;
        int e = 0;
        int count = 0;
        int countMax = 0;

        while(s<intervals.size()){
            if(start[s] < end[e]){
                count++;
                countMax = Math.max(count,countMax);
                s++;
            }else{
                count--;
                e++;
            }

        }
         return countMax;

        

        

    }
}
