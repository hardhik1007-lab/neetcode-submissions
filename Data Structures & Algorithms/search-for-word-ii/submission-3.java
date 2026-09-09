class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    List<String> res= new ArrayList<>();
    class TrieNode{
        TrieNode[] children;
        String word;

        public TrieNode(){
            children = new TrieNode[26];
            word = null;
        }
    }

    
    public List<String> findWords(char[][] board, String[] words) {

        

        // Add words in trie

        TrieNode node = new TrieNode();
        
        for(String word : words){
            TrieNode n = node;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(n.children[c - 'a'] == null){
                    n.children[c - 'a'] = new TrieNode();
                }
                n = n.children[c - 'a'];
            }
            n.word = word;
        }
        //* trie built

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(node, board, i, j);
            }
        }

        return res;
    }

    public void dfs(TrieNode node, char[][] board, int i, int j){

        char c = board[i][j];

        if(node.children[c - 'a'] == null){
            return;
        }
        node = node.children[c - 'a'];

        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }


        board[i][j] = '*';
        
        for(int[] d : dir){
            int nr = d[0] + i;
            int nc = d[1] + j;

            
            if(nr < board.length && nr >= 0 && nc < board[0].length && nc >=0 && board[nr][nc] != '*' && node.children[board[nr][nc] - 'a'] != null){
                dfs(node, board, nr, nc);
            }
        }
        board[i][j] = c;
        return;


        
    }
}
