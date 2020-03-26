class Solution {
    public int maxSubArray(int[] nums) {
        //Divide and Conquer Approach
        if(nums.length==1)
            return nums[0];
        else
            return maxSubArray(nums, 0, nums.length-1);    
    }
    
    public int maxSubArray(int[] nums, int start, int end){
        //Divide array to left and right subarry until reaches to single element in subarray: Base case
        if(start==end)
            return nums[start];
        
        //Get Mid 
        int mid=(start+end)/2;
        
        //return maximum of max sub array in left arr, max sub array in right arr, or crossSum
        return Math.max(Math.max(maxSubArray(nums, start, mid), maxSubArray(nums, mid+1, end)), crossingSum(nums, start, end, mid));
    }
    
    //crossSum is the maximum subarray sum such that subarray crossed mid point
    public int crossingSum(int[] nums, int start, int end, int mid){
        int sum=0;
        int lSum=Integer.MIN_VALUE;
        int rSum=Integer.MIN_VALUE;
        
        //Maximum sum starting from mid point and ending at some point on left of mid
        for(int i=mid; i>=start;i--){
            sum+=nums[i];
            if(sum>lSum)
                lSum=sum;
        }
        sum=0;
        
        //Maximum sum starting from mid + 1 and ending with sum point on right of mid + 1
        for(int i=mid+1; i<=end;i++){
            sum+=nums[i];
            if(sum>rSum)
                rSum=sum;
        }
        
        return lSum+rSum;
    }
}

//Leetcode Syntax
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
