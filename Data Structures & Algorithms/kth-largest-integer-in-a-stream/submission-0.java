class KthLargest {

    private PriorityQueue<Integer> minHeap;
    int len;

    public KthLargest(int k, int[] nums) {
        len = k;
        minHeap = new PriorityQueue<>();
        for(int num:nums){
            minHeap.offer(num);
            if(minHeap.size()> len){
                minHeap.poll();
            }
        }

        
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()> len){
                minHeap.poll();
            }
        
        return minHeap.peek();


        
    }
}
