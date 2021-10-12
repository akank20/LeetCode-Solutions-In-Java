package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MaxLenConcatenatedStrWIthUniqueChar_2 {
    private static int max;
    private static int[] bitMask;
    private static int[] length;
    
    public static int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0){
            return 0;
        }else if(arr.size() == 1){
            return getBitMask(arr.get(0)) == 0 ? 0 :  arr.get(0).length();
        }else{
            HashSet<String> set = new HashSet<String>();
            for(String word : arr){
                // ignore blank strings and words with duplicate characters
                // also eliminate duplicates by using a HashSet
                if(getBitMask(word) != 0){  
                    set.add(word);
                }
            }
            
            if(set.isEmpty()){
                return 0;
            }
            
            List<String> list = new ArrayList<String>(set);
            int i, n = list.size();
            bitMask = new int[n];
            length = new int[n];
            
            for(i = 0; i < n; i++){
                length[i] = list.get(i).length();
                bitMask[i] = getBitMask(list.get(i));
            }
            
            max = 0;
            dfs(list, 0, n, 0, 0);
            return max;
        }
    }
    
    private static void  dfs(List<String> arr, int index, int n, int lengthTillNow, int mask){
        max = Math.max(max, lengthTillNow);
        if(index == n){
            return;
        }else{
            int maskTillNow = mask;
            for(int i = index; i < n; i++){
                if((bitMask[i] & maskTillNow) == 0){
                    // can be concatenated
                    dfs(arr, i + 1, n, lengthTillNow + length[i], maskTillNow | bitMask[i]);
                }
            }
        }
    }
    
    private static int getBitMask(String s){
        int mask = 0;
        int i, j, n = s.length();
        
        for(i = 0; i < n; i++){
            j = (1 << (s.charAt(i) - 'a'));
            if((mask & j) == 0){
                mask = (mask | j);
            }else{
                return 0; // duplicate characters
            }
        }
        
        return mask;
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
		List<String> a3=new ArrayList<>();
		a3.add("abcdefghijklmnopqrstuvwxyz");
		System.out.println(maxLength(a2));
		for(int i: bitMask)
			System.out.print(i+" ");
	}
}