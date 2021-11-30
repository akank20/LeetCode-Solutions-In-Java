class Solution {
    boolean[][] visited;
    int n, m;
   //Array to visit the adjacent nodes
    int[][] dirs = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
  
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if((word.charAt(0) == board[i][j]) && dfs(board, word,i,j,0))
                    return true;
            }
        }        
        return false;
    }
  
    public boolean dfs(char[][] board, String word, int i, int j, int idx){
        if(idx == word.length())
            return true;
      //If index is out of bound or char already visited or current char does not matches the next letter in word
        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || word.charAt(idx) != board[i][j])
            return false;
        visited[i][j] = true;
        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(dfs(board, word, nr, nc, idx+1))
                return true;
        }
        visited[i][j] = false;
        return false;
    }
}
