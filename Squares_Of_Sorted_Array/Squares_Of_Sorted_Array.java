class Solution {

    //Solution Using Two Pointers Approach: O(N)
    public int[] sortedSquares(int[] A) {
        int pos=0;
        int neg=0;
        int N=A.length;
        int i=0;
        int[] squared=new int[N];
        
        //Point one pointer to the first positive element
        while(pos<N && A[pos]<0){
            pos++;
        }
        
        //Point other pointer to the last negative value
        neg=pos-1;
        i=0;
        
        //Iterate through array and compare squares of pos and neg elements in array to fill the new array in sorted order
        while(neg>=0 && pos<N){
            if(A[neg]*A[neg]<=A[pos]*A[pos]){
                squared[i]=A[neg]*A[neg];
                i++; neg--;
            }
            else{
                squared[i]=A[pos]*A[pos];
                i++; pos++;
            }
        }
        
        //Edge Cases:
        while(neg>=0){
            squared[i]=A[neg]*A[neg];
            i++; neg--;
        }
        
        while(pos<N){
            squared[i]=A[pos]*A[pos];
            i++; pos++;    
        }
        
        return squared;
    }
}
