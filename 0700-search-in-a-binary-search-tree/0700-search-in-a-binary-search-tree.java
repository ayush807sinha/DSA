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
    static TreeNode ans = null;

    public static void find(TreeNode node,int key){
        if(node==null){
            return;
        }

        if(node.val==key){
            ans = node;
            return;
        }
        if(node.val>key){
            find(node.left,key);
        }else{
            find(node.right,key);
        }

        return;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        ans = null;
        find(root,val);
        return ans;
    }
}