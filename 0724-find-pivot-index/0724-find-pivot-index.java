class Solution {
    public int pivotIndex(int[] arr) {
       int left =0 ;
       int sum =0;

       for(int i=0;i<arr.length;i++){
            sum= sum+arr[i];
       } 

       for(int i=0;i<arr.length;i++){
            int right = sum - left -arr[i];

            if(left == right){
                return i;
            }
            left = left +arr[i];
       }

       return -1;
    }
}