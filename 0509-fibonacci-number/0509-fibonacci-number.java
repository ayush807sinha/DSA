class Solution {
    int fun(int n, int dp[]) {
        if (n == 1 || n == 0) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = fun(n - 1, dp) + fun(n - 2, dp);
        dp[n] = ans;
        return dp[n];
    }

    public int fib(int n) {
        int dp[] = new int[n + 1];   

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        return fun(n,dp);               
    }
}