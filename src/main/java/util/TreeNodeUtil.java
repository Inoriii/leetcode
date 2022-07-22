package main.java.util;

import main.java.common.TreeNode;

/**
 * @author sakura
 */
public class TreeNodeUtil {
    public static <T> TreeNode<T> array2Tree(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return doArray2Tree(array, 1);
    }

    /**
     * DFS
     */
    private static <T> TreeNode<T> doArray2Tree(T[] array, int position) {
        if (position > array.length) {
            return null;
        }
        TreeNode<T> result = new TreeNode<>();
        result.val = array[position - 1];
        int left = position * 2;
        int right = position * 2 + 1;
        TreeNode<T> lTreeNode = doArray2Tree(array, left);
        if (lTreeNode != null && lTreeNode.val != null) {
            result.left = lTreeNode;
        }
        TreeNode<T> rTreeNode = doArray2Tree(array, right);
        if (rTreeNode != null && rTreeNode.val != null) {
            result.right = rTreeNode;
        }
        return result;
    }
}
