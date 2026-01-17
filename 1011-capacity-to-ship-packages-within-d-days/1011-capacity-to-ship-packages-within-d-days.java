class Solution {

    public boolean find(int arr[],int days,int n,int guess){
        int d = 1;
        int weight =0;
        for(int i=0;i<n;i++){
            if(arr[i]>guess){
                return false;
            }
            if(arr[i]+weight <=guess){
                weight = weight + arr[i]; 
            }else{
                d++;
                weight = arr[i];
            }
        }

        if(d<=days){
            return true;
        } 
        return false;
    }

    public int shipWithinDays(int[] arr, int days) {
        int low = 1;
        int high = 0;
        int  n = arr.length;
        int ans= -1;
        for(int i=0;i<n;i++){
            high = high +arr[i];
        }

        while(low <=high){
            int guess =  (low +high)/2;

            boolean temp = find(arr,days,n,guess);

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