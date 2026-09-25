class Node{

    Node prev;
    Node next;
    int key;
    int val;
    int freq;


    public Node(int key, int val){
        this.val = val;
        this.key = key;
        this.prev = null;
        this.next = null;
        this.freq = 1;


    }

}

class Dll{

    Node head;
    Node tail;

    public Dll(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node){

        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;



    }

    public void add(Node node){

        Node right = tail;
        Node left  = tail.prev;
        left.next = node;
        node.next = right;
        right.prev = node;
        node.prev = left;

    }
}



class LFUCache {

    HashMap<Integer, Dll> fregroups;
    HashMap<Integer, Node> nodemap;
    int min;
    int capacity;

    public LFUCache(int capacity) {

        this.fregroups = new HashMap<>();
        fregroups.put(1, new Dll());
        this.nodemap = new HashMap<>();
        this.min = 0;
        this.capacity = capacity;
        
    }
    
    public int get(int key) {

        if(!nodemap.containsKey(key)){
            return -1;
        }

        Node node = nodemap.get(key);
        int fre = node.freq;
        
        Dll list = fregroups.get(fre);
        list.remove(node);

        if((min == fre)){

            if(list.head.next == list.tail){
                min++;
            }


        }

        fre++;
        node.freq = fre;
        if(!fregroups.containsKey(fre)){
            fregroups.put(fre, new Dll());
        }
        fregroups.get(fre).add(node);



        return node.val;
        
    }
    
    public void put(int key, int value) {

        

        if(nodemap.containsKey(key)){
            Node node = nodemap.get(key);
            node.val = value;
            int fre = node.freq;
            Dll list = fregroups.get(fre);
            list.remove(node);
            if((min == fre) && (list.head.next == list.tail)){
                min++;
            }
            fre++;
            node.freq = fre;
            if(!fregroups.containsKey(fre)){
                fregroups.put(fre, new Dll());
            }
            fregroups.get(fre).add(node);
        }else{
            
            if(nodemap.size() == capacity){

                Dll list = fregroups.get(min);
                Node removeNode = list.head.next;
                list.remove(removeNode);
                nodemap.remove(removeNode.key);
            }
            Dll list1 = fregroups.get(1);
            Node node = new Node(key,value);
            list1.add(node);
            nodemap.put(key, node);
            min = 1;

            
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */