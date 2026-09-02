public class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean eow;

}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
         
    }

    

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx]==null){
                node.children[idx] = new TrieNode();

            }
            node= node.children[idx];
        }
        node.eow= true;

    }

    public boolean search(String word) {

        TrieNode node= root;
        for(char c : word.toCharArray()){
            int idx= c - 'a';
            if(node.children[idx]==null){
                return false;
            }
            node = node.children[idx];
        }
        return node.eow;

    }

    public boolean startsWith(String prefix) {
        TrieNode node= root;
        for(char c : prefix.toCharArray()){
            int idx= c - 'a';
            if(node.children[idx]==null){
                return false;
            }
            node = node.children[idx];
        }
        return true;

    }
}
 