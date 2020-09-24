public class Main {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
        for(int[] row: grid){
            for(int ele:row)
                System.out.print(ele);
            System.out.println();
        }
	    System.out.println(minDays(grid));
    }
    
    public static int minDays(int[][] grid){
        
        //Check boundary conditions
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0)
            return 0;
            
        //Use queue to Store zombies
        Queue<int[]> queue=new LinkedList<>();
        
        int zombies=0, hours=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[i].length;j++){
                //found Zombie in grid in cell {i,j}
                if(grid[i][j]==1){
                    //add cell in queue
                    queue.offer(new int[]{i,j});
                    zombies++;
                }
            }
        }
        
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        //Check if adjacent cells of zombies are Humans
        while(!queue.isEmpty()){
            int size=queue.size();
            
            //number of zombies are equal to number of cells in grid: All humans converted to zombies
            if(zombies==(grid.length*grid[0].length))
                return hours;
            
            //Else check adj cell and convert humans to zombies
            for(int i=0;i<size;i++){
                int curr[] = queue.poll();
                
                for(int[] dir: dirs){
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];
                    
                    //Found human in cell {nr,nc}
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==0){
                        zombies++;
                        //Add new zombie cell in queue
                        queue.offer(new int[]{nr,nc});
                        //Update grid
                        grid[nr][nc]=1;
                    }       
                }
            }
            hours++;
        }
        
        return -1;
    }
}
