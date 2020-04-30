class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
          return 0;
        }
        int isl=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1')
                    isl++;
                    dfs(grid, i, j);
            }
        }
        return isl;
    }
    
    public void dfs(char[][] grid, int r, int c){
        
        if(r>grid.length || c>grid[0].length)
            return;
        
        int[][] dirs= {{0,1}, {0,-1},{1,0},{-1,0}};
        
        if(grid[r][c]=='0')
            return;
        
        for(int[] dir:dirs){
            int nr=r+dir[0];
            int nc=c+dir[1];
                
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]=='1'){
                dfs(grid, nr, nc);  
            }
            grid[r][c]='0';
        }
    }
}
