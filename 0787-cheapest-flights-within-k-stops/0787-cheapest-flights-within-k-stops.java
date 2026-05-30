class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] res = new int[n];

        Arrays.fill(res, Integer.MAX_VALUE);
        res[src] = 0; 

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(res, n); 

            for (int j = 0; j < flights.length; j++) {
                int s = flights[j][0]; 
                int d = flights[j][1];
                int wt = flights[j][2];

                if (res[s] != Integer.MAX_VALUE && temp[d]> res[s] + wt) {
                    temp[d] = res[s] + wt;
                }
            }
            res = temp;
        }

        return res[dst] == Integer.MAX_VALUE ? -1 : res[dst];
    }
}