package amazon;

public class ShipWithinDays {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println(shipWithinDays(arr, 5));

	}
	
	public static int shipWithinDays(int[] weights, int days) {
        int sum = 0, numEle = 0;
        
        for(int weight : weights){
            sum += weight;
            numEle = Math.max(numEle,weight);
        }
        //System.out.println("Sum: "+sum +" max Weight: "+numEle);    
        while(numEle < sum){
            int mid = numEle + (sum - numEle)/2;
            int reqDays = 1, currWeight = 0;
            for(int weight: weights){
                if(currWeight + weight > mid){
                    reqDays++;
                    currWeight = 0;
                }
                currWeight += weight;
            }
            if(reqDays > days)
                numEle = mid +1;
            else
                sum = mid;           
        }        
        return numEle;
    }

}
