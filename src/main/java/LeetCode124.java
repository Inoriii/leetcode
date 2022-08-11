package main.java;

import main.java.common.TreeNode;
import main.java.util.TreeNodeUtil;

/**
 * @author sakura
 */
public class LeetCode124 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPatchSum(root);
        return max;
    }

    private Integer getMaxPatchSum(TreeNode root) {
        if (root == null) return 0;

        Integer val = (Integer) root.val;
        max = Math.max(max, val);

        TreeNode left = root.left;
        int leftMax = 0;
        if (left != null) {
            leftMax = getMaxPatchSum(left);
        }

        TreeNode right = root.right;
        int rightMax = 0;
        if (right != null) {
            rightMax = getMaxPatchSum(right);
        }
        int maxChild = 0;
        if (left != null || right != null) {
            if (left != null && right != null) {
                maxChild = Math.max(leftMax, rightMax);
            } else if (left != null) {
                maxChild = leftMax;
            } else {
                maxChild = rightMax;
            }
            max = Math.max(max, maxChild);
            max = Math.max(max, val + maxChild);
        }
        max = Math.max(max, val + leftMax + rightMax);

        return Math.max(val, val + maxChild);
    }

    public static void main(String[] args) {
        LeetCode124 leetCode12 = new LeetCode124();
        TreeNode root = TreeNodeUtil.array2Tree(new Integer[]{-3});
        int i = leetCode12.maxPathSum(root);
        System.out.println(i);
    }
}
