class Solution {
    public static int findHour(int arr[],int speed){
        int h =0;

        for(int i=0;i<arr.length;i++){
            h = h+ arr[i]/speed;
            if(arr[i]%speed!=0){
                h++;
            }
        }

        return h;
    }
    public int minEatingSpeed(int[] arr, int h) {
        int n = arr.length;
        int low = 1;
        int high=0;
        int ans = -1;

        for(int i=0;i<n;i++){
            if(arr[i]>high){
                high = arr[i];
            }
        }

        while(low<=high){
            int speed = low +(high-low)/2;

            int time = findHour(arr,speed);

            if(time > h){
                low = speed+1;
            }else{
                ans = speed;
                high = speed-1;
            }

        }

        return ans;

    }
}