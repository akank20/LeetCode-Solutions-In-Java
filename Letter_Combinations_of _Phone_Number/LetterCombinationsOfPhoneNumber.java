class Solution {
    
// Time complexity: O((4 ^ N) * N)
	public List<String> letterCombinations(String digits) {

		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty() || digits.length() == 0)
			return ans;
		// mapping
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		while (ans.peek().length() != digits.length()) {
			String remove = ans.remove();
			int curr = digits.charAt(remove.length()) - '0';
			String map = mapping[curr];
			for (char c : map.toCharArray()) {
				ans.addLast(remove + c);
			}
		}
		return ans;
	}
}
