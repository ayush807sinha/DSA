class Solution {
    
    
    static boolean find(int[] arr, int index, int sum) {
        if (sum == 0) return true;
        if (index == arr.length) return false;

  
        if (arr[index] <= sum) {
            if (find(arr, index + 1, sum - arr[index])) {
                return true;
            }
        }

        
        return find(arr, index + 1, sum);
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        return find(arr,0,sum);
    }
}