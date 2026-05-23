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
    TreeNode prev= null;
    TreeNode g1first = null;
    TreeNode g1second = null;
    TreeNode g2first = null;
    TreeNode g2second = null;
    int checker = 0;

    public void find(TreeNode node){
        if(node==null){
            return;
        }

        find(node.left);
        if(prev == null){
            prev = node;
        }else{
            if(node.val < prev.val){
                if(checker ==0){
                    g1first = prev;
                    g1second = node;
                    checker++;
                }else{
                    g2first = prev;
                    g2second = node;
                    checker++;
                }
            }
            prev = node;
        }
        find(node.right);
    }




    public void recoverTree(TreeNode root) {
        find(root);
        if(checker == 1){
            int temp = g1first.val;
            g1first.val = g1second.val;
            g1second.val = temp;
        }else{
            int temp = g1first.val;
            g1first.val =g2second.val;
            g2second.val = temp;
        }
        return;
    }
}