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
    int maxHeight = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxDepthUtil(root, 0);
        return maxHeight + 1;
    }
    
    public void maxDepthUtil(TreeNode root, int height){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            maxHeight = Math.max(maxHeight, height);
        }
        
        maxDepthUtil(root.left, height+1);
        maxDepthUtil(root.right, height+1);
        return;
    }
}