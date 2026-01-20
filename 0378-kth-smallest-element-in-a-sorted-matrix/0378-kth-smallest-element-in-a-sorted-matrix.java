class Solution {
    public int find(int matrix[][],int  m ,int n ,int guess){
        int row = n-1;
        int col =0;
        int count = 0;
        while(row>=0 && col<n){
            if(matrix[row][col] <= guess){
                count = count + row +1;
                col++;
            }else{
                row--;
            }
        }

        return count;

    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        int res =-1;

        while(low <= high){
            int guess =  (low +high)/2;
            
            int ans = find(matrix,m,n,guess);

            if(ans<k){
                low = guess+1;
            }else{
                res =  guess;
                high = guess-1;
            }
        }

        return res;

    }
}