class MyCircularQueue {

    int[] ca;
    int size;
    int front;
    int rear;
    int k;

    public MyCircularQueue(int k) {
        this.ca = new int[k + 1];
        size = 0;
        this.front = 0;
        this.rear = 0;
        this.k = k;
        
    }
    
    public boolean enQueue(int value) {

        if(isFull()){
            return false;
        }
        ca[rear] = value;
        rear = (rear + 1) % (k + 1);
        size++;
        return true;
        
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % (k + 1);
        size--;
        return true;
        
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return ca[front];
        
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }

        return ca[(rear - 1 + k + 1) % (k + 1)];
        
    }
    
    public boolean isEmpty() {
        if(rear == front){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if((rear + 1) % (k + 1) == front){
            return true;
        }
        return false;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */