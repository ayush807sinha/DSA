class Solution {
    public int findMaxLength(int[] arr) {
        int n = arr.length;
        int zero =0;
        int one =0;

        Map<Integer,Integer> map = new HashMap<>();

        int res =0;

        for(int i =0 ;i<n;i++){

            if(arr[i] ==0){
                zero++;
            }else{
                one++;
            }

            if(zero == one){
                res = Math.max(res,i+1);
                continue;
            }
            int diff = zero-one;
            if(!map.containsKey(diff)){
                map.put(diff,i);
            }else{
                int len = i - map.get(diff);
                res = Math.max(res,len);
            }

        }

        return res;

    }
}