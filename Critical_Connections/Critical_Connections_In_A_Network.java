class Solution {
    
    //Using DFS
    
    int id=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(List<Integer> oneConnection :connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        
        boolean[] visited=new boolean[n];
        int[] lowLink=new int[n];
        int[] ids=new int[n];
        List<List<Integer>> bridge=new ArrayList();
        
        for(int i=0;i<n-1;i++){
            if(!visited[i]){
                dfs(graph, i, -1, bridge, visited, lowLink, ids);
            }
        }
        return bridge;
    }
    
    public void dfs(List<Integer>[] graph, int curr, int prev, List<List<Integer>> bridge, boolean[] visited, int[] lowLink, int[] ids){
        visited[curr]=true;
        id=id+1;
        lowLink[curr]=id;
        ids[curr]=id;
        
        for(int node:graph[curr]){
            if(node==prev)
                continue;
            if(!visited[node]){
                dfs(graph, node, curr, bridge, visited, lowLink, ids);
                lowLink[curr]=Math.min(lowLink[curr], lowLink[node]);
                
                if(ids[curr]<lowLink[node]){ 
                    bridge.add(new ArrayList(Arrays.asList(curr, node)));
                }
            }
            else{
                lowLink[curr]=Math.min(lowLink[curr], ids[node]);
            }
        }
            
    }
}

//Leetcode Syntax
public class MainClass {
    private static List<Integer> stringToIntegerList(String input) {
      JsonArray jsonArray = JsonArray.readFrom(input);
      List<Integer> arr = new ArrayList<>(jsonArray.size());
      for (int i = 0; i < jsonArray.size(); i++) {
        arr.add(jsonArray.get(i).asInt());
      }
      return arr;
    }
    
    public static List<List<Integer>> stringToInt2dList(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
          return new ArrayList<List<Integer>>();
        }
    
        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          list.add(stringToIntegerList(cols.toString()));
        }
        return list;
    }
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            List<List<Integer>> connections = stringToInt2dList(line);
            
            List<List<Integer>> ret = new Solution().criticalConnections(n, connections);
            
            String out = int2dListToString(ret);
            
            System.out.print(out);
        }
    }
}
