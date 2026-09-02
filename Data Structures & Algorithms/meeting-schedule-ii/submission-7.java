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

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;

        }

        int maxRoom = 0;

        Arrays.sort(start);
        Arrays.sort(end);

        int l = 0, r = 0;
        int room = 0;

        while(l<start.length && r < end.length){
            if(start[l] < end[r]){
                room++;
                l++;
                maxRoom = Math.max(maxRoom, room);
            }else{
                room--;
                r++;
                
            }
        }

        return maxRoom;



        

    }
}
