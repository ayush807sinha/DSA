class Solution {

    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int start1 = arr[0][0];
        int end1 = arr[0][1];

        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {

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


    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> newarr = new ArrayList<>();

        int start = newInterval[0];
        boolean inserted = false;

        for (int i = 0; i < intervals.length; i++) {

          
            if (!inserted && start < intervals[i][0]) {
                newarr.add(new int[]{newInterval[0], newInterval[1]});
                inserted = true;
            }

            newarr.add(new int[]{intervals[i][0], intervals[i][1]});
        }

        
        if (!inserted) {
            newarr.add(new int[]{newInterval[0], newInterval[1]});
        }

        int[][] arr = newarr.toArray(new int[newarr.size()][]);

        return merge(arr);
    }
}
