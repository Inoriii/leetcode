package main.java;

import main.java.common.TreeNode;
import main.java.util.TreeNodeUtil;


class LeetCode572 {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null&&subRoot == null) {
            return true;
        }
        if (root == null&&subRoot != null) {
            return false;
        }
        if (!(root.val == subRoot.val && isSubtree2(root.left, subRoot.left) && isSubtree2(root.right, subRoot.right))) {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        return true;
    }

    public static boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (root == null&&subRoot == null) {
            return true;
        }
        if (root == null&&subRoot != null) {
            return false;
        }
        if (root!= null&&subRoot== null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return isSubtree2(root.left, subRoot.left) && isSubtree2(root.right, subRoot.right);
        }
        return false;
    }


    public static void main(String[] args) {
        Integer[] rootInteger1 = new Integer[]{3, 4, 5, 1, 2};
        Integer[] subRootInteger1= new Integer[]{4, 1, 2};
        TreeNode<Integer> root1 = TreeNodeUtil.array2Tree(rootInteger1);
        TreeNode<Integer> subRoot1 = TreeNodeUtil.array2Tree(subRootInteger1);
        boolean b1 = isSubtree(root1, subRoot1);
        System.out.println(b1);

        Integer[] rootInteger2 = new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0};
        Integer[] subRootInteger2= new Integer[]{4, 1, 2};
        TreeNode<Integer> root2 = TreeNodeUtil.array2Tree(rootInteger2);
        TreeNode<Integer> subRoot2 = TreeNodeUtil.array2Tree(subRootInteger2);
        boolean b2 = isSubtree(root2, subRoot2);
        System.out.println(b2);
    }
}