package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OptimalUtilization {

	public static void main(String[] args) {
		List<List<Integer>> a=new ArrayList<>();
		List<Integer> a1=new ArrayList<>();
		a1.add(1);
		a1.add(3);
		List<Integer> a2=new ArrayList<>();
		a2.add(2);
		a2.add(5);
		List<Integer> a3=new ArrayList<>();
		a3.add(3);
		a3.add(7);
		List<Integer> a4=new ArrayList<>();
		a4.add(4);
		a4.add(10);
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		
		List<List<Integer>> b=new ArrayList<>();
		List<Integer> b1=new ArrayList<>();
		b1.add(1);
		b1.add(2);
		List<Integer> b2=new ArrayList<>();
		b2.add(2);
		b2.add(3);
		List<Integer> b3=new ArrayList<>();
		b3.add(3);
		b3.add(4);
		List<Integer> b4=new ArrayList<>();
		b4.add(4);
		b4.add(5);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);

		List<List<Integer>> res= getPairs(a,b,10);
		
		for(List<Integer> arr:res) {
			System.out.print("[");
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			System.out.println("]");
		}
		/*
		 * System.out.println(); for(List<Integer> arr:b) { for(int ele:arr) {
		 * System.out.print(ele+" "); } System.out.println(); }
		 */

	}
	
	public static List<List<Integer>> getPairs(List<List<Integer>> a, List<List<Integer>> b, int target) {
		
		Comparator<List<Integer>> cmp = Comparator.comparing(p -> p.get(1));

		Collections.sort(a, cmp);
		Collections.sort(b, cmp.reversed());
		int maxSum = Integer.MIN_VALUE;
		ArrayList<List<Integer>> maxPairs = new ArrayList<>();
		for (int i = 0, j = 0; i < a.size() && j < b.size();) {
			List<Integer> x = a.get(i);
			List<Integer> y = b.get(j);
			int curSum = x.get(1) + y.get(1);
			if (curSum > target) {
				j++;
				continue;
			}
			if (curSum > maxSum) {
				maxSum = curSum;
				maxPairs.clear();
			}
			for (int k = j; k < b.size(); k++) {
				List<Integer> z = b.get(k);
				if (z.get(1) != y.get(1))
					break;
				maxPairs.add(List.of(x.get(0), z.get(0)));
			}
			i++;
		}
		return maxPairs;
	}

}
