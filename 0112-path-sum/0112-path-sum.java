/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean res =false;

    public  void  find(TreeNode root,int sum,int target){
        if(root == null){
            return;
        }

        sum = sum+ root.val;

        if(root.left == null && root.right ==null){
            if(sum ==target){
                res = true;
            }
            return;
        }

        find(root.left,sum,target);
        find(root.right,sum,target);
        return;
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum =0;
        find(root,sum,targetSum);
        return res;
    }
}