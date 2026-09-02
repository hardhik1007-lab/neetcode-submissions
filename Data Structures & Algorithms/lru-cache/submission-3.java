class Node{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    int cap;
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    


    

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head= new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        
    }

    public void deleteNode(Node node){
    
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;
        

    }

    public void addNode(Node node){
        
        Node left = this.tail.prev;
        left.next = node;
        node.prev = left;
        this.tail.prev = node;
        node.next = this.tail;


    }

    public void addToTail(Node node){
        deleteNode(node);
        addNode(node);

    }


    
    public int get(int key) {
        if(cache.containsKey(key)){
            addToTail(cache.get(key));
            return cache.get(key).value;

        }else{
            return -1;

        }
        
    }
    
    public void put(int key, int value) {
        //update the value if key present
        if(cache.containsKey(key)){
            cache.get(key).value = value;
            addToTail(cache.get(key));
        }else{
            Node node  = new Node(key, value);
            if(cache.size()>=cap){
                Node lru = head.next;
                deleteNode(lru);
                cache.remove(lru.key);
            }
            cache.put(key, node);
            addNode(node);
            

        }
        
        
        
    }
}
