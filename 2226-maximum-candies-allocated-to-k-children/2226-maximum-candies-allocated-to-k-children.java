class Solution {
    public boolean find(int arr[],int n,int guess,long k){
        long child=0;

        for(int i=0;i<n;i++){
            
            int kitnako = arr[i]/guess;

            child =child + kitnako;
        }

        if(child<k){
            return false;
        }
        return true;

    }
    public int maximumCandies(int[] arr, long k) {
        int low = 1;
        int n= arr.length;
        int high = 0;
        for(int i =0;i<n;i++){
            if(arr[i]>high){
                high = arr[i];
            }
        }

        int ans =0;

        while(low <= high){
            int guess = (low +high)/2;

            boolean temp = find(arr,n,guess,k);

            if(temp){
                ans = guess;
                low = guess+1;
            }else{
                high = guess-1;
            }
        }

        return ans;
    }
}