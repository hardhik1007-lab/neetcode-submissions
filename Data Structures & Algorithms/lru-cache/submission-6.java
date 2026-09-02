class Node {

    int val;
    Node prev;
    Node next;
    int key;
    public Node(int val, int key){
        this.val = val;
        this.key = key;
        this.prev = null;
        this.next = null;

    }
}

class LRUCache {
    int capacity;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head= new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.prev = head;
        
    }

    public void delete(Node node){
        Node left = node.prev;
        Node right= node.next;
        left.next = right;
        right.prev= left;


    }
    public void add(Node node){

        Node left = tail.prev;
        left.next= node;
        node.prev = left;
        node.next = tail;
        tail.prev= node;

    }

    public void addEnd(Node node){
        delete(node);
        add(node);

    }
    
    public int get(int key) {

        if(map.containsKey(key)){
            Node cur = map.get(key);
            addEnd(cur);
            return cur.val;
        }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        //update if present
        if(map.containsKey(key)){
            map.get(key).val = value;
            addEnd(map.get(key));
        

        }else{
            Node node= new Node(value, key);
            map.put(key, node);
            add(node);
            if(map.size() > capacity){
                Node lru = head.next;
                delete(lru);
                map.remove(lru.key);
            }

        }

        
        
    }
}
