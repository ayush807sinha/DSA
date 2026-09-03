class Solution {

    public void swap(int i ,int j ,int arr[]){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =  temp;

    }



    public int[] sortArrayByParity(int[] arr) {
        int n =arr.length;

        if(n==1 || n==0){
            return arr;
        }


        int low=0;
        int high=0;

        while(high<n){

            if(arr[high] % 2==0){
                swap(low,high,arr);
                low++;
            }
            high++; 
        }

        return arr;

    }
}