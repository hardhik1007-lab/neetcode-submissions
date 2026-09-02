class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size()> 1){
            int st1 = maxHeap.poll();
            int st2 = maxHeap.poll();
            if(st1 == st2){
                continue;
            }else{
                maxHeap.offer(Math.abs(st1 - st2));
            }
        }

        if(maxHeap.size() == 0){
            return 0;
        }

        return maxHeap.peek();
        
    }
}
