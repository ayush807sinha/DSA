class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low =0;
        int high = arr.length-1;
        int res =-1;

        while(low <= high){
            int guess = low + (high-low)/2;

            if(arr[guess] <=arr[n-1]){
                res = arr[guess];
                high = guess-1;
            }else{
                low = guess+1;
            }

        }

        return res;
    }
}