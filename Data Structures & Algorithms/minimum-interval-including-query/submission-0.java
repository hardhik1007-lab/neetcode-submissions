class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int[] res = new int[queries.length];

        int[][] sortedqueries = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            sortedqueries[i][0]  = queries[i];
            sortedqueries[i][1] = i;
        }
        Arrays.sort(sortedqueries, (a, b) -> Integer.compare(a[0], b[0]));

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));

        int i = 0;

        for(int[] query: sortedqueries){
            int q = query[0];

            while((i < intervals.length) && (intervals[i][0] <= q)){

                if(intervals[i][1] >= q){
                    int len = intervals[i][1] - intervals[i][0] + 1;
                    minheap.add(new int[]{intervals[i][0], intervals[i][1], len});
                }
                
                i++;
            }

            while(!minheap.isEmpty() && minheap.peek()[1] < q){
                minheap.poll();
            }

            if(!minheap.isEmpty()){
                res[query[1]] = minheap.peek()[2];
            }else{
                res[query[1]] = -1;
            }

            
            
        }

        return res;


        
    }
}
