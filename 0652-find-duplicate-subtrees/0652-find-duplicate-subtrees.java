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
   public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), res);
        return res;
    }

    public String traverse(TreeNode node, Map<String, Integer> cnt, List<TreeNode> res) {
        if (node == null) {
            return "#";
        }
        String triplet = node.val + "," + traverse(node.left, cnt, res) + "," + traverse(node.right, cnt, res);
        
        cnt.put(triplet, cnt.getOrDefault(triplet, 0) + 1);
        if (cnt.get(triplet) == 2) {
            res.add(node);
        }
        return triplet;
    }
}