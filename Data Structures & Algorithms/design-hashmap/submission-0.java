class Node{
    int key;
    int val;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

class MyHashMap {

    Node[] map;
    public MyHashMap() {
        this.map = new Node[1000];
        for(int i = 0; i < 1000; i++){
            Node dummy = new Node(-1,-1);
            map[i] = dummy;
        }
    }
    
    public void put(int key, int value) {

        int idx = key % 1000;
        Node prev = map[idx];
        Node cur = prev.next;
        while(cur != null){
            if(cur.key == key){
                cur.val = value;
                return;
            }
            prev = cur;
            cur = cur.next;

        } 

        Node node = new Node(key, value);
        prev.next = node;
        
    }
    
    public int get(int key) {
        int idx = key % 1000;
        Node cur = map[idx].next;
        while(cur != null){
            if(cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        } 

        return -1;
        
    }
    
    public void remove(int key) {

        int idx = key % 1000;
        Node prev = map[idx];
        Node cur = prev.next;
        while(cur != null){
            if(cur.key == key){
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        } 
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */