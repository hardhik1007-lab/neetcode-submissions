class node{
    node[] children;
    boolean eow;

    public node(){
        children = new node[26];
        eow =false;
    }
}


class WordDictionary {

    private node root;
     

    public WordDictionary() {
        root = new node();

    }

    public void addWord(String word) {


        if(root == null){
            return;
        }
        node n = root;
        for(char c : word.toCharArray()){
            int idx= c - 'a';
            if(n.children[idx]==null){
                n.children[idx] = new node();
            }
            n = n.children[idx];
        }
        n.eow = true;

    }

    public boolean search(String word) {
        return dfs(word,0,root);
        
    }

    public boolean dfs(String word, int j, node no ){
        if(no == null){
            return false;
        }
        node n = no;
        for(int i = j; i< word.length(); i++){
            char c = word.charAt(i);
            int idx = c - 'a';

            if(c == '.'){
                for(int k = 0 ; k<26;k++){
                    if(n.children[k]!=null && dfs(word,i+1, n.children[k])){
                        return true;
                    }
                }
                return false;

            }else{
                if(n.children[idx] == null){
                return false;
                }
                n = n.children[idx];

            }
            
            
            
        }
        return n.eow;


    }
} 
