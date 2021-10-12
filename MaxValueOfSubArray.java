package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MaxValueOfSubArray {
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,4,3,5};
		System.out.println(findSubset(arr));
	}

	private static int findSubset(int[] arr) {
		int sum = 0;
		int[] next = Arrays.copyOf(arr, arr.length);	
		Arrays.sort(next);
		int[] prev = Arrays.copyOf(arr, arr.length);
		Integer[] prevArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Collections.reverse(Arrays.asList(prevArr));
	
		for(int i=0; i<arr.length;i++) {
			int subArr = (next[i]-i+1)*(i-prevArr[i]+1);
			//(nextLargest[i]-i+1)*(i-previousLargest[i]+1);
			sum += subArr;
		}
		
		return sum;
	}
	
	
}
