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

    public int find(TreeNode node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right==null){
            return 1;
        }
        
        if(node.left == null){
            return find(node.right)+1;
        }

        if(node.right ==null){
            return find(node.left)+1;
        }

        int left = find(node.left)+1;
        int right = find(node.right)+1;

        return Math.min(left,right);
    }
    public int minDepth(TreeNode root) {
        int ans=find(root);
        return ans;
    }
}