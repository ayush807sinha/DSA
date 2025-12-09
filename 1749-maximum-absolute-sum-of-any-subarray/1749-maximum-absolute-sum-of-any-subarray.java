class Solution {
    public static int minSum(int[] arr){
        int res = arr[0];
        int best = arr[0];

        for(int i =1;i<arr.length;i++){
            best = Math.min(arr[i],arr[i]+best);
            res = Math.min(res,best);
        }

        return res;

    }
    public static int maxSum(int[] arr){
        int res = arr[0];
        int best = arr[0];

        for(int i =1;i<arr.length;i++){
            best = Math.max(arr[i],arr[i]+best);
            res = Math.max(res,best);
        }

        return res;

    }


    public int maxAbsoluteSum(int[] arr) {
        int maxsum = Math.abs(maxSum(arr));
        int minsum = Math.abs(minSum(arr));

        int res = Math.max(maxsum,minsum);

        return res;

    }
}