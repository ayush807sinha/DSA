class Solution {
    public static int find(int m,int n,int guess){
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, guess / i);
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int ans =-1;
        int low = 1;
        int high = m*n;

        while(low <=high){
            int guess = (low +high)/2;

            int res = find(m,n,guess);

            if(res<k){
                low = guess+1;
            }else{
                ans = guess;
                high =guess-1;
            }
        }

        return ans;
    }
}