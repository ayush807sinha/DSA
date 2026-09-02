class Solution {
    
    void swap(int i ,int j , int arr[]){
        
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
    
    void segregate0and1(int[] arr) {
        // code here
        int n = arr.length;

        int low =0;
        int high = n-1;
        
        
        while(low<=high){
            
            if(arr[low] == 0){
                low++;
            }else{
                swap(low,high,arr);
                high--;
            }
        }




    }
}
