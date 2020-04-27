class Solution {

//Simple solution by counting frequency of words and eliminating words from banned list

    public String mostCommonWord(String paragraph, String[] banned) {
        
        //Split paragraph by regex (!?',;.) and converting to lower case
        String[] words=paragraph.toLowerCase().split("\\W+");
        String common_word=null;
        int count=0;
        Set<String> ban = new HashSet<>();
        for(String s: banned) {
            ban.add(s);
        }
        
        Map<String, Integer> freq=new HashMap<>();
        
        for(String s:words){
            if(!ban.contains(s)){
                freq.put(s,freq.getOrDefault(s,0)+1);
                if(freq.get(s)>count){
                    count=freq.get(s);
                    common_word=s;
                }
            }
        }
        return common_word;
    }
}


//Leetcode Syntax copied
public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String paragraph = stringToString(line);
            line = in.readLine();
            String[] banned = stringToStringArray(line);
            
            String ret = new Solution().mostCommonWord(paragraph, banned);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}
