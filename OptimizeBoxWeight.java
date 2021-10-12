package amazon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;



public class OptimizeBoxWeight {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { -5, -2, -3, -1, -2, -10};
		List<Integer> list = Arrays.asList(arr);
		List<Integer> res = optimizingBoxWeights(list);
		System.out.println("Maximal sum subset: " + res);

	}

	public static List<Integer> optimizingBoxWeights(List<Integer> arr) {

		int target = arr.stream().reduce(0, Integer::sum) / 2;
		// return List.of();
		System.out.println(target);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
		pq.addAll(arr);
		int curSum = 0;
		List<Integer> res = new ArrayList<>();
		while (curSum <= target) {
			int val = pq.poll();
			curSum += val;
			res.add(val);
		}
		Collections.reverse(res);
		return res;
	}

}
