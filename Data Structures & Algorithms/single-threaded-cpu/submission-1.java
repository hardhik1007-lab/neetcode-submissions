class Solution {
    public int[] getOrder(int[][] tasks) {

        
        int[] res= new int[tasks.length];
        int resIndex = 0;

        ///= enqueue time {enqueuetime, processing time, index}
        int[][] enqueue = new int[tasks.length][3];
        for(int i = 0; i < tasks.length; i++){
            enqueue[i][0] = tasks[i][0];
            enqueue[i][1] = tasks[i][1];
            enqueue[i][2] = i;
        }
        Arrays.sort(enqueue, (a,b) -> Integer.compare(a[0],b[0]));


        int time = 0;
        int i = 0;
        // heap {processing time, index}
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) ->{
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        while(i < enqueue.length || !heap.isEmpty()){
            while(i < enqueue.length && enqueue[i][0] <= time){
                heap.add(new int[]{enqueue[i][1],enqueue[i][2]});
                i++;
            }

            if(!heap.isEmpty()){
                int[] x = heap.poll();
                time += x[0];
                res[resIndex] = x[1];
                resIndex++;
                
            }

            //jump to next time
            if(heap.isEmpty() && i < enqueue.length && time < enqueue[i][0]){
                time = enqueue[i][0];
            }
        }

        return res;

        
    }
}