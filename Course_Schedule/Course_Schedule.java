class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        boolean[] visited=new boolean[numCourses];
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        
        for(int[] course:prerequisites){
            //Fill in hashmap to create graph
            if(graph.containsKey(course[1])){
                graph.get(course[1]).add(course[0]);
            }
            else{
                List<Integer> coursepreReqs=new LinkedList<Integer>();
                coursepreReqs.add(course[0]);
                graph.put(course[1], coursepreReqs);
            }
        }
        
        //Loop through each node to check if it contains any loop/cycle
        for(int node=0;node<numCourses;node++){
            if(cyclicGraph(node, graph, visited))
                return false;
        }
        return true;
    }
    
    public boolean cyclicGraph(int course, HashMap<Integer,List<Integer>> graph, boolean[] visited){
        
        //Already visited: loop detetcted- Graph is cyclic
        if(visited[course])
            return true;
        
        //If node does not have any directed edges
        if(!graph.containsKey(course))
            return false;
        
        //mark node as visited and check outgoing edges for cycles
        visited[course]=true;
        
        for(int node: graph.get(course)){
            if(cyclicGraph(node, graph, visited))
                return true;
        }
        //Unmark visited node for next iteration
        visited[course]=false;
        
        return false;
    }
}

//Leetcode syntax, Main method
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
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int numCourses = Integer.parseInt(line);
            line = in.readLine();
            int[][] prerequisites = stringToInt2dArray(line);
            
            boolean ret = new Solution().canFinish(numCourses, prerequisites);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}
