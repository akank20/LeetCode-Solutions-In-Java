
class Solution {
    //Brute-Force - O(n^2)
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length; i++){ // Sub-array Start Index
            int sum=0;
            for( int j=1;j<=nums.length;j++){ //Sub-array size
                
                if((i+j)>nums.length) //Checking here if index exceeds array size
                    break;
                
                sum+=nums[i+j-1]; //To remove extra loop, add last element of new sub-array
                maxSum=Math.max(sum, maxSum); // Store maximum sum in result
            }
        }
        return maxSum; 
    }
}

//Leetcode syntax
public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution().maxSubArray(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
