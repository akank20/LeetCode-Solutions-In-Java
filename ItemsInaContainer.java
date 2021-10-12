package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsInaContainer {

	public static void main(String[] args) {
		// "*|**|*|*"
		String s1 = "*|**|*|*";
		Integer[] arr1 = new Integer[] { 1, 1 };
		Integer[] arr2 = new Integer[] { 5, 6 };

		List<Integer> startIndices = Arrays.asList(arr1);
		List<Integer> endIndices = Arrays.asList(arr2);

		// Test case 1:
		List<Integer> res1 = countItemsInCompartments(s1, startIndices, endIndices);
		System.out.println("Number  of items in a container:" + res1);

	}

	public static List<Integer> countItemsInCompartments(String s, List<Integer> startIndices,
			List<Integer> endIndices) {
		List<Integer> totalItems = new ArrayList<>();

		if (startIndices.size() == endIndices.size()) {

		}
		return totalItems;
	}

}
