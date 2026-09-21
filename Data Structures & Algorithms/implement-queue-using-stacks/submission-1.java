class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        
    }
    
    public void push(int x) {
        

        int size = stack1.size();
        for(int i = 0; i < size; i++){
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        for(int i = 0; i <size + 1; i++){
            stack1.push(stack2.pop());
        }
        
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {

        return stack1.peek();
        
    }
    
    public boolean empty() {
        return stack1.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */