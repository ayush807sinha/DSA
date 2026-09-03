class Solution {
    public static void swap(int i,int j ,int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int i,int j ,int arr[]){

        while(i<=j){
            swap(i,j,arr);
            i++;j--;
        }

    }
    public void rotate(int[] arr, int k) {
        int n = arr.length;

        k = k % n;

        reverse(0,n-1,arr);
        reverse(0,k-1,arr);
        reverse(k,n-1,arr);
      
    }
}