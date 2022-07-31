package main.java;

import main.java.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sakura
 */
public class Leetcode1161 {
    int deep, max = Integer.MIN_VALUE;

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        maxLevelSum(deque, deep);
        return deep;
    }

    private void maxLevelSum(Deque<TreeNode> deque, int deep) {
        ++deep;
        if (deque.size() == 0) return;
        int sum = 0;
        for (int i = deque.size() - 1; i >= 0; i--) {
            TreeNode treeNode = deque.pollFirst();
            sum += (Integer) treeNode.val;
            if (treeNode.left != null) deque.offer(treeNode.left);
            if (treeNode.right != null) deque.offer(treeNode.right);
        }
        if (max < sum) {
            this.deep = deep;
            this.max = sum;
        }
        maxLevelSum(deque, deep);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(-8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        Leetcode1161 leetcode1161 = new Leetcode1161();
        int i = leetcode1161.maxLevelSum(treeNode1);
        System.out.println(i);
    }
}