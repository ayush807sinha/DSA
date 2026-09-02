class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        int n = arr.length;

        Arrays.sort(arr);

        int low =0;
        int high =n-1;
        int boat=0;

        while(low <= high){
            
            int remain = limit - arr[high];
            high = high-1;
            boat++;

            if(low <= high && remain >= arr[low]){
                low = low+1;
            }

        }

        return boat;


    }
}