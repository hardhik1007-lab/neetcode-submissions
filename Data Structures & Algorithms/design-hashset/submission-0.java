class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

class MyHashSet {
    Node[] set;
    public MyHashSet() {

        set = new Node[1000];
        for(int i = 0; i < 1000; i++){
            Node dummy = new Node(0);
            set[i] = dummy;
        }
        
    }
    
    public void add(int key) {
        if(contains(key)){
            return;
        }else{
            int val = key % 1000;
            Node p = set[val];
            Node cur  = new Node(key);
            cur.next = p.next;
            p.next = cur;
        }
        
    }
    
    public void remove(int key) {

        int val = key % 1000;

        Node prev = set[val];
        Node cur = prev.next;
        
        while(cur != null){
            if(cur.val == key){
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }    
    }
    
    public boolean contains(int key) {
        int val = key % 1000;
        Node cur = set[val];
        cur = cur.next;

        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */