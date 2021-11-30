class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap();
        String[] str = s.split(" ");
        if(pattern.length() != str.length)
            return false;
        for(int i = 0; i < str.length; i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch) && !map.get(ch).equals(str[i]))
                return false;
            else if(!map.containsKey(ch)){
                if(map.containsValue(str[i]))
                    return false;
                else
                    map.put(ch, str[i]);
            }               
        }        
        return true;
    }
}
