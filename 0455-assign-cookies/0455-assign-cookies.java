class Solution {
    public int findContentChildren(int[] greed, int[] cookie) {
       Arrays.sort(greed);
        Arrays.sort(cookie);

        int i = 0; 
        int j = 0; 
        int count = 0;

        while (i < greed.length && j < cookie.length) {
            if (cookie[j] >= greed[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;

    }
}