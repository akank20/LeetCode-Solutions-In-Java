
class Solution {
    int[][] DIRS = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    char[][] grid = null;
    List<String> res = new ArrayList<String>();
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode(); 
        //create trie with given words
        for(String word: words){
            TrieNode curr = root;
            for(Character ch : word.toCharArray()){
                if(curr.children.containsKey(ch)){
                    curr = curr.children.get(ch);
                }
                else{
                    TrieNode node = new TrieNode();
                    curr.children.put(ch, node);
                    curr = node;
                }
            }
            curr.word = word;
        }
        
        //backtrack for each cell
        this.grid = board;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(root.children.containsKey(board[i][j]))
                    dfs(i, j, root);
            }
        }
        return this.res;
    }
    
    public void dfs(int r, int c, TrieNode node){
        Character ch = grid[r][c];
        TrieNode curr = node.children.get(ch);
        if(curr.word != null){
            res.add(curr.word);
            curr.word = null;
        }
        
        grid[r][c] = '#';
        for(int[] dir : DIRS){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr < 0 || nc < 0 || nr >= this.grid.length|| nc >= this.grid[0].length)
                continue;
            if(curr.children.containsKey(this.grid[nr][nc]))
                dfs(nr, nc, curr);
        }
        this.grid[r][c] = ch;
        if(curr.children.isEmpty())
            node.children.remove(ch);
    }
    
    private class TrieNode{
        HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
        String word = null;
        public TrieNode(){}
    }
}
