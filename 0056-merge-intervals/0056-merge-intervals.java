class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int start1 = arr[0][0];
        int end1 = arr[0][1];


        for(int i =1 ;i<arr.length;i++){
            int start2 = arr[i][0];
            int end2 = arr[i][1];

            if (end1 >= start2) {
                end1 = Math.max(end1, end2); 
            } else {
                
                result.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }
        result.add(new int[]{start1, end1});
        return result.toArray(new int[result.size()][]);

    }
}