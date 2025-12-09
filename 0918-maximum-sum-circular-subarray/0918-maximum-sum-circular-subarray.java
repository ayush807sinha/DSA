class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        
        int maxsum = arr[0];
        int minsum = arr[0];
        int total = arr[0];
        int currmax = arr[0];
        int currmin = arr[0];

        for(int i =1;i<arr.length;i++){
            total = total+arr[i];

            currmax = Math.max(arr[i],currmax+arr[i]);
            maxsum = Math.max(maxsum,currmax);

            currmin = Math.min(arr[i],currmin+arr[i]);
            minsum = Math.min(minsum,currmin);

        }
        if(maxsum<0) return maxsum;

        return Math.max(maxsum,total-minsum);

        
    }
}