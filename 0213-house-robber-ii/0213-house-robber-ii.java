class Solution {
    public static int find(int arr[]){
        int n = arr.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return arr[0];
        }

        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);

        for(int i=2;i<n;i++){
            int pick = arr[i] + dp[i-2];
            int notpick = 0 + dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }

        return dp[n-1];
        
    }
    public int rob(int[] arr) {
        int n = arr.length;
        if(n==1){
            return arr[0];
        }
        int temp1[] = new int[n-1];
        int temp2[] = new int[n-1];

        for(int i =0;i<temp1.length;i++){
            temp1[i] = arr[i];
            temp2[i] = arr[i+1];
        }

        int ans1 = find(temp1);
        int ans2 =  find(temp2);

        return Math.max(ans1,ans2);
    }
}