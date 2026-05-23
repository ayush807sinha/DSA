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
    TreeNode prev = null;
    boolean ans = true;
    public void find(TreeNode node){
        if(node == null){
            return;
        }
        find(node.left);
        if(prev == null){
            prev = node;
        }else{
            if(node.val <= prev.val){
                ans =false;
            }
            prev = node;
        }
        find(node.right);


    } 
    public boolean isValidBST(TreeNode root) {
        find(root);
        return ans;
    }
}