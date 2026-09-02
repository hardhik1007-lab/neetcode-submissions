class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> array;
    

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.array = new ArrayList<>();
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        array.add(val);
        int idx = array.size() - 1;
        map.put(val, idx);
        return true;
        
        
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val) && array.size()>0){
            int idx = map.get(val);
            int last_val = array.get(array.size() - 1);
            array.set(idx, last_val);
            map.put(last_val, idx);
            array.remove(array.size() - 1);
            map.remove(val);
            return true; 
        }
        return false;
        
    }
    
    public int getRandom() {

        Random rand = new Random();
        int index = rand.nextInt(array.size());
        return array.get(index);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */