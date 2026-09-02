class MinStack {
    private List<Integer> stack;
    private List<Integer> min;
    public MinStack() {
      stack = new ArrayList<>(); 
      min = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
       

        if(min.isEmpty()||val<=min.get(min.size()-1)){
            min.add(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int idx= stack.size()-1;
        int top = stack.get(idx);
        if(top == min.get(min.size()-1)){
            min.remove(min.size()-1);
        }
        stack.remove(idx);
        
    }
    
    public int top() {
           
        return stack.get(stack.size()-1);
        
    }
    
    public int getMin() {
        return min.get(min.size()-1);
        
    }
}
