class Solution {
    public int subarraySum(int[] arr, int k) {
        int sum =0 ;
        Map<Integer,Integer> map = new HashMap<>();
        int res =0;

        map.put(0,1);

        for(int i =0;i<arr.length;i++){

            sum = sum+arr[i];

            int quest = sum - k;

            int freq = map.getOrDefault(quest, 0);

            res = res + freq;

            map.put(sum,map.getOrDefault(sum,0)+1);


        }

        return res;

    }
}