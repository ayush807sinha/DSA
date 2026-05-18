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

    public static boolean find(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }
        
        boolean ans1 = find(root1.left,root2.left);

        boolean ans2 = find(root1.right,root2.right);

        if(ans1 && ans2){
            return true;
        }

        return false;


    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean res = find(p,q);

        return res;
    }
}