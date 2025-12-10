class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int res =0 ;
        int sum =0;

        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        for(int i =0;i<arr.length;i++){

            sum = sum + arr[i];

            int rem = sum % k;

            if(rem<0){
                rem = rem + k;
            }

            res += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return res;
    }
}