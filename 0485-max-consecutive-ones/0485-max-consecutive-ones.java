class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n =arr.length;
        int max =0 ;
        int one =0;

        for(int i=0;i<n;i++){
            if(arr[i]==1){
                one++;
            }else{
                max = Math.max(max,one);
                one = 0;
            }
        }

        max =Math.max(max,one);

        return max;
    }
}