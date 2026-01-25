class Solution {
    public int findKthLargest(int[] arr, int k) {
        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }

        int ans =0;
        for(int i=0;i<k;i++){
            ans = pq.poll();
        }

        return ans;
    }
}