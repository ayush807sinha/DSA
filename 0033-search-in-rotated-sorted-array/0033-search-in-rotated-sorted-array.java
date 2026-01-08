class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int n = arr.length;

        while (low <= high) {
            int mid = (low +high) / 2;

            if (arr[mid] == target) {
                return mid;
            }

    
            if (arr[mid] > arr[n - 1]) {
                if (target >= arr[0] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
         
            else {
                if (target > arr[mid] && target <= arr[n - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
