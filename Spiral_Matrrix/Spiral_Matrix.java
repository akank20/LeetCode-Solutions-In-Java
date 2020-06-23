class Solution {
    //Method to return matrix elements in spiral form
    
    public List<Integer> spiralOrder(int[][] matrix) {
    
        List<Integer> spiral=new ArrayList<>();
        //Checking edge cases
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return spiral;
            
        int rowS=0, rowE=matrix.length-1;
        int colS=0, colE=matrix[0].length-1;
        
        //O(N)
        while(rowS<=rowE && colS<=colE){
            for(int col=colS; col<=colE; col++)
                spiral.add(matrix[rowS][col]);
            for(int row=rowS+1; row<=rowE; row++)
                spiral.add(matrix[row][colE]);
            if(rowS<rowE && colS<colE){
                for(int col=colE-1; col>colS; col--)
                    spiral.add(matrix[rowE][col]);
                for(int row=rowE; row>rowS; row--)
                    spiral.add(matrix[row][colS]);
            }
            rowS++; colS++;
            rowE--; colE--;
        }
        
        return spiral;
    }
}
