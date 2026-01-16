class Solution {
    public boolean find(int arr[],int k,int n,int guess){
        int student = 1;
        int pages =0;
        for(int i=0;i<n;i++){
            if (arr[i] > guess) return false;
            if(arr[i]+pages<=guess){
                pages = pages+arr[i];
            }else{
                student++;
                pages =arr[i];
                if(student>k){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public int findPages(int[] arr, int k) {
        if(arr.length<k){
            return -1;
        }
        int n = arr.length;
        
        int low = 0;
        
        int high =0;
        
        for(int i=0;i<n;i++){
            low = Math.max(low,arr[i]);
            high=high+arr[i];
        }
        
        int ans = -1;
        
        while(low <=high){
            int guess = low +(high-low) /2;
            
            boolean temp = find(arr,k,n,guess);
            
            if(temp){
                ans = guess;
                high = guess-1;
            }else{
                low = guess +1;
            }
        
        }
        
        return ans;
        
        
        
    }
}