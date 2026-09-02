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
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        if(intervals.size() == 0){
            return true;
        }
        int start = intervals.get(0).start;
        int end= intervals.get(0).end;

        for(int i = 1; i<intervals.size(); i++){
            start = intervals.get(i).start;

            if(start<end){
                return false;
            }
            end = Math.max(end, intervals.get(i).end);
        }

        return true;

    }
}
