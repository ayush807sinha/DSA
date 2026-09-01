class Solution {
    public List<List<Integer>> threeSum(int[] arr) {

        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        int i = 0;

        while (i < n - 2) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }

            int k = i + 1;
            int j = n - 1;

            while (k < j) {

                int sum = arr[i] + arr[k] + arr[j];

                if (sum == 0) {

                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[k]);
                    temp.add(arr[j]);

                    ans.add(temp);

                    k++;
                    j--;

                    
                    while (k < j && arr[k] == arr[k - 1]) {
                        k++;
                    }

                    while (k < j && arr[j] == arr[j + 1]) {
                        j--;
                    }

                } 
                else if (sum < 0) {
                    k++;
                } 
                else {
                    j--;
                }
            }

            i++;
        }

        return ans;
    }
}
