class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;
    int max;
    int min;

    public MedianFinder() {
        this.minheap = new PriorityQueue<>();
        this.maxheap = new PriorityQueue<>(Collections.reverseOrder());
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;

        
    }
    
    public void addNum(int num) {
        if(maxheap.isEmpty()){
            maxheap.offer(num);     
        }else if(num > maxheap.peek()){
            minheap.offer(num);
        }else{
            maxheap.offer(num);
        }

        if(Math.abs(minheap.size() - maxheap.size()) > 1){
            if(minheap.size() > maxheap.size()){
                int x = minheap.poll();
                maxheap.offer(x);
            }else{
                int x = maxheap.poll();
                minheap.offer(x);
            }

        }
        
    }
    
    public double findMedian() {

        int size = minheap.size() + maxheap.size();
        if(size % 2 == 0){
            return (minheap.peek() + maxheap.peek()) / 2.0;
        }else{
            if(minheap.size() > maxheap.size()){
                return minheap.peek();
            }else{
                return maxheap.peek();
            }
        }
        
    }
}
