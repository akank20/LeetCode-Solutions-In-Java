class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0]==null || rooms[0].length==0)
            return;
        
        int INF=Integer.MAX_VALUE;
        Queue<int[]> queue=new LinkedList<>();
        
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        int[][] dirs={ {0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            for(int[] dir:dirs){
                int ni=cell[0]+dir[0];
                int nj=cell[1]+dir[1];
                if(ni>=0 && ni<rooms.length && nj>=0 && nj<rooms[0].length && rooms[ni][nj]==INF){
                    rooms[ni][nj]=rooms[cell[0]][cell[1]]+1;
                    queue.offer(new int[]{ni,nj});
                }
            }
        }
    }
}

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
    
    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }
    
        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append(Integer.toString(item));
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] rooms = stringToInt2dArray(line);
            
            new Solution().wallsAndGates(rooms);
            String out = int2dArrayToString(rooms);
            
            System.out.print(out);
        }
    }
}
