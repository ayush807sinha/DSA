class Solution {
    public int findPeakElement(int[] arr) {
        
        int low = 0;
        int high = arr.length-1;

        while(low < high){
            int guess = low + (high-low) /2;

            if(arr[guess] > arr[guess+1]){
                high = guess;
            }else{
                low = guess +1;
            }
        }

        return low;

    }
}