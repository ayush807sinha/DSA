class Solution {

    public static boolean find(int arr[],int m,int k,int n,int guess){
        int cnt=0;
        int sum=0;

        for(int i =0;i<n;i++){
            if(arr[i]<=guess){
                cnt++;
            }else{
                sum = sum + (cnt/k);
                cnt=0;
            }
        }

        sum = sum + (cnt/k);

        if(sum>=m){
            return true;
        }else{
            return false;
        }
    }
    public int minDays(int[] arr, int m, int k) {
        int n = arr.length;
        int low =0;
        int high = 0;
        for(int i=0;i<n;i++){
            if(arr[i]>=high){
                high = arr[i];
            }
        }
        int ans = -1;
        while(low <=high){
            int guess = (low+high)/2;

            boolean tempans = find(arr,m,k,n,guess);

            if(tempans){
                ans = guess;
                high =guess-1; 
            }else{
                low = guess+1;
            }

        }

        return ans;
    }
}