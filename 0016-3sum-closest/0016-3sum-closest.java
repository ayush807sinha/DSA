class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int n = arr.length;
        int diff = arr[0] + arr[1] + arr[2];
        int i =0;
        Arrays.sort(arr);

        while(i<n-2){

            int j = i+1;
            int k = n-1;

            while(j<k){

                int sum = arr[i] + arr[j] + arr[k];

                if(Math.abs(sum - target) < Math.abs(diff-target)){
                    diff = sum;
                }

                if(sum == target){
                    return sum;
                }else if (sum <target){
                    j++;
                }else{
                    k--;
                }

            }
            i++;

        }

        return diff;

    }
}