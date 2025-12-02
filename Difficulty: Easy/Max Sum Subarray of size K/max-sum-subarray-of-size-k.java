class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int low =0;
        int high = k-1;
        
        int sum=0;int result =0;
        
        for(int i=low;i<=high;i++){
            sum = sum+arr[i];
        }
        
        while(high<n){
            result = Math.max(sum,result);
            
            low++;high++;
            
            if(high==n){
                break;
            }
            
            sum = sum - arr[low-1] + arr[high];
            
            
        }
        
        return result;
        
    }
}