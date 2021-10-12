package amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthConcatenatedStrWithUniqCHar {
	public static int maxLength(List<String> arr) {
        int len = 0;
        if(arr == null || arr.size() == 0)
            return 0;
        List<String> res = generateSubstr(arr, 0);
        
//        for(int i = 0; i < res.size(); i++){
//            len = (len > res.get(i).length())?len:res.get(i).length();
//        }
        len = res.stream().max(Comparator.comparing(String::length)).get().length();
        
        return len;
    }
    
    public static List<String> generateSubstr(List<String> arr, int idx){
        List<String> list =new ArrayList<>();
        if(idx == arr.size()){
            list.add("");
            return list;
        }        
        List<String> tempList = generateSubstr(arr, idx+1);
        List<String> res =new ArrayList<>(tempList);
        for(String str: tempList){
            String substr = str + arr.get(idx);
            if(isUnique(substr))
                res.add(substr);
        }        
        return res;        
    }
    
    public static boolean isUnique(String s){
        Set<Character> set = new HashSet<>();
        for(char ch:s.toCharArray()){
            if(set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }
    
    public static void main(String[] args) {
    	List<String> a1=new ArrayList<>();
		a1.add("un");
		a1.add("iq");
		a1.add("ue");
		//"cha","r","act","ers"
		List<String> a2=new ArrayList<>();
		a2.add("cha");
		a2.add("r");
		a2.add("act");
		a2.add("ers");
		System.out.println(maxLength(a2));
	}
}


