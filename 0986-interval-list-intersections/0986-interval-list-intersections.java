class Solution {
    public int[][] intervalIntersection(int[][] arr1, int[][] arr2) {
        Arrays.sort(arr1,(a,b)->a[0]-b[0]);

        Arrays.sort(arr2,(a,b)->a[0]-b[0]);

        List<int[]> res = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;

        int i=0;int j=0;

        while(i<n && j<m){

            int start1 = arr1[i][0];
            int end1 = arr1[i][1];

            int start2 = arr2[j][0];
            int end2 = arr2[j][1];


            int s = Math.max(start1,start2);
            int e = Math.min(end1,end2);

            if(s <= e){
                res.add(new int[]{s,e});
            }

            if(end1 <= end2){
                i++;
            }else{
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);


    }
}