class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> queue = new ArrayDeque<>();
        // build hashmap for task frequency
        for(char task: tasks){
            hash.put(task,hash.getOrDefault(task,0) + 1);
        }
        // put the values into maxheap
        for(int i:hash.values()){
            maxheap.add(i);
        }
        int time = 0;

        // run loop until we poll all tasks from maxheap.
        while(!maxheap.isEmpty()||!queue.isEmpty()){
            time++;
            if(!maxheap.isEmpty()){
                int curr  = maxheap.poll();
                curr--;
                
                if(curr>0){
                    queue.add(new int[]{curr,time+n});
            }
            }
            
            
            
            if(!queue.isEmpty() && queue.peek()[1]==time){
                maxheap.add(queue.poll()[0]);
            }

        }

        return time;





        
    }
}
