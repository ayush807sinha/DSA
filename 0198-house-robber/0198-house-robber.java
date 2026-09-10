class Solution {

    public int find(int n,int arr[]){
        int dp[] = new int[n];

        dp[0] = arr[0];
        if(n==1){
            return arr[0];
        }
        if(n>=2){
            dp[1] = Math.max(arr[0],arr[1]);
        }
        
        for(int i=2;i<n;i++){
            int c1 = arr[i] + dp[i-2];
            int c2 = dp[i-1];
            dp[i] = Math.max(c1,c2);
        }

        return dp[n-1];


    }

    public int rob(int[] arr) {
        
        int n = arr.length;
         return find(n,arr);

    }
}