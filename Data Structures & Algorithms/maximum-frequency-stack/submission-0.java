class FreqStack {

    HashMap<Integer, Stack<Integer>> groups;
    HashMap<Integer, Integer> freq;
    int maxF;

    public FreqStack() {
        this.groups = new HashMap<>();
        this.freq = new HashMap<>();
        this.maxF = Integer.MIN_VALUE;
    }
    
    public void push(int val) {

        // calculate the new freq of the val
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int f = freq.get(val);
        maxF = Math.max(f, maxF);

        // push ontpo new freq stack
        if(groups.containsKey(f)){
            groups.get(f).push(val);
        }else{
            groups.put(f, new Stack<>());
            groups.get(f).push(val);

        }


        
    }
    
    public int pop() {

        int res = groups.get(maxF).pop();
        freq.put(res, freq.get(res) - 1);

        if(groups.get(maxF).isEmpty()){
            maxF--;
        }
        return res;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */