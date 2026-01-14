class Solution {
    
    public static boolean find(int arr[],int k , int guess){
        int n = arr.length;
        int cow =1;
        
        int prev = arr[0];
        for(int i=1;i<n;i++){
            int dist = arr[i]-prev;
            if(dist>=guess){
                cow++;
                prev = arr[i];
            }
        }
        
        if(cow>=k){
            return true;
        }else{
            return false;
        }
        
    }
    
    public int aggressiveCows(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = -1;
        int low =1;
        int high = arr[n-1] - arr[0];
        
        
        while(low <=high){
            int guess = low +(high-low)/2;
            
            boolean tempans = find(arr,k,guess);
            
            if(tempans){
                ans = guess;
                low = guess+1;
            }else{
                high = guess-1;
            }
        }
        
        return ans;
        
        
    }
}