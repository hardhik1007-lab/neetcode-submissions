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

        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        

        for(Interval i : intervals){


            if(!minHeap.isEmpty() && i.start >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.offer(i.end);
        }

        return minHeap.size();



        

    }
}
