class MovingAverage {
    int sum;
    int[] data;
    int index=0;
    int count=0;
    int size;
    

    public MovingAverage(int size) {
        this.size = size;
        data= new int[size];

    

        
    }
    
    public double next(int val) {
        if (count == size) {
                sum -= data[index];

            } else {
                count++;
            }


        data[index] = val;
        index = (index + 1) % size;
        sum+=val;
        
        return (double)sum / count;
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
