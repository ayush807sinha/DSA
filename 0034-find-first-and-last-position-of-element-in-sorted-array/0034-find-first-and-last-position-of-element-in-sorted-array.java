class Solution {
    public static int first(int nums[],int target){
        int low = 0;
        int high = nums.length-1;
        int start=-1;

        while(low<=high){
            int guess = low + (high - low) / 2;
            if(nums[guess]==target){
                start = guess;
                high = guess-1;
            }else if(nums[guess]>target){
                high = guess-1;
            }else{
                low =guess+1;
            }
        }

        return start;
    }
    public static int last(int nums[],int target){
        int low =0;
        int high = nums.length-1;
        int end =-1;
        while(low<=high){
            int guess = low + (high - low) / 2;
            if(nums[guess]==target){
                end = guess;
                low = guess+1;
            }else if(nums[guess]>target){
                high = guess -1;
            }else{
                low = guess+1;
            }
        }

        return end;
    }
    public int[] searchRange(int[] nums, int target) {
       int start = first(nums,target);
       int end = last(nums,target);

        return new int[]{start,end};
    
    }
}