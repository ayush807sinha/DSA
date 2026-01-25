class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int ans =0;
        for(int i=0;i<k;i++){
            ans = pq.poll();
        }
        
        return ans;
        
    }
}

        


