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
        Node prev= new Node(0);
        Node temp = prev;
        while(cur != null){
            Node node = new Node(cur.val);
            map.put(cur,node);
            temp.next = node;
            temp= node;
            cur = cur.next;
        }
        temp.next = null;

        //assign random using built hashmaps
        Node ran = head;
        while(ran != null){
            Node node2 = map.get(ran);
            node2.random = map.get(ran.random);
            ran = ran.next;
        }

        return prev.next;




        
    }
}
