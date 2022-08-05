package main.java;

import main.java.common.TreeNode;

/**
 * @author sakura
 */
public class Leetcode632 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode addNode = new TreeNode(val);
            addNode.left = root;
            return addNode;
        }
        dfs(1, root, val, depth);
        return root;
    }

    private void dfs(int nowDepth, TreeNode nowNode, int val, int depth) {
        if (nowDepth == depth - 1) {
            TreeNode lNode = nowNode.left;
            TreeNode rNode = nowNode.right;
            TreeNode addLNode = new TreeNode(val);
            TreeNode addRNode = new TreeNode(val);
            nowNode.left = addLNode;
            nowNode.right = addRNode;
            addLNode.left = lNode;
            addRNode.right = rNode;
            return;
        }
        if (nowNode != null) {
            if (nowNode.left != null) dfs(nowDepth + 1, nowNode.left, val, depth);
            if (nowNode.right != null) dfs(nowDepth + 1, nowNode.right, val, depth);
        }
    }
}