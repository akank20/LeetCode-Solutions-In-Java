class Solution {
    //Using BFS
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0)
            return 0;
        
        int freshOrange=0;
        int minutes=0;
        Queue<int[]> queue= new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    freshOrange++;
                }
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        if(freshOrange==0)
                return minutes;
        
        int[][] dirs= { {0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty()){
            if(freshOrange==0)
                return minutes;
            
            int size=queue.size();
            
            for(int i=0; i<size;i++){
                int[] cell=queue.poll();
                for(int[] dir:dirs){
                    int ni=cell[0]+dir[0];
                    int nj=cell[1]+dir[1];
                    if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && grid[ni][nj]==1){
                        freshOrange--;
                        grid[ni][nj]=2;
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }
            minutes++;
        }
        return -1;
    }
}

//LeetCode Syntax
public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
          return new int[0][0];
        }
    
        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] grid = stringToInt2dArray(line);
            
            int ret = new Solution().orangesRotting(grid);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
