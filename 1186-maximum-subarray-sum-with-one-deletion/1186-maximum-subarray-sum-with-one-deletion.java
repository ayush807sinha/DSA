class Solution {
    public int maximumSum(int[] arr) {
        
        int nodelete = arr[0];
        int onedelete = -1000000000;

        int res =arr[0];

        for(int i =1;i<arr.length;i++){
            int prevnodelete = nodelete;
            
            nodelete = Math.max(arr[i],arr[i]+nodelete);

            onedelete = Math.max(prevnodelete,onedelete+arr[i]);

            res = Math.max(res,Math.max(nodelete,onedelete));

        }

        return res;

    }
}