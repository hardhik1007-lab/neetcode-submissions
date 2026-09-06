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
        int size = minheap.size() + maxheap.size();
        if(size % 2 == 0){
            if(num <= this.min){
                maxheap.offer(num);
                this.max = maxheap.peek();
            }else{
                minheap.offer(num);
                this.min = minheap.peek();
            }
        }else{
            if(minheap.size() < maxheap.size()){
                if(max > num){
                    maxheap.offer(num);
                    int x = maxheap.poll();
                    minheap.offer(x);
                    this.max = maxheap.peek();
                    this.min = minheap.peek();
                }else{
                    minheap.offer(num);
                    this.min = minheap.peek();
                }
            }else{
                if(min < num){
                    minheap.offer(num);
                    int x = minheap.poll();
                    maxheap.offer(x);
                    this.max = maxheap.peek();
                    this.min = minheap.peek();
                }else{
                    maxheap.offer(num);
                    this.max = maxheap.peek();
                }
            }



        }
        
    }
    
    public double findMedian() {

        int size = minheap.size() + maxheap.size();
        if(size % 2 == 0){
            return (min + max) / 2.0;
        }else{
            if(minheap.size() > maxheap.size()){
                return minheap.peek();
            }else{
                return maxheap.peek();
            }
        }
        
    }
}
