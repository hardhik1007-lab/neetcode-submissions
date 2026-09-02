/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();

        // create the copy; and build map
        Node cur = head;
        
        while(cur != null){
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        

        //assign random using built hashmaps
        cur = head;
        while(cur != null){
            Node node2 = map.get(cur);
            node2.next = map.get(cur.next);
            node2.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);




        
    }
}
