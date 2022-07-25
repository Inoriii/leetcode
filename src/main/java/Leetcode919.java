package main.java;

import main.java.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sakura
 */
public class Leetcode919 {

    static class CBTInserter {

        private TreeNode root;
        private int length;


        private int getLength(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);
            return getLength(deque);
        }

        private int getLength(Deque<TreeNode> deque) {
            int size = deque.size();
            if (size == 0) return 0;
            for (int i = size; i > 0; --i) {
                TreeNode treeNode = deque.pollFirst();
                if (treeNode.left != null) deque.add(treeNode.left);
                if (treeNode.right != null) deque.add(treeNode.right);
            }
            return getLength(deque) + size;
        }

        private TreeNode getSuperNode(int length) {
            if (length == 1) return this.root;
            if (length % 2 == 0) {
                TreeNode superNode = getSuperNode(length / 2);
                if (superNode.left == null) return superNode;
                return superNode.left;
            } else {
                TreeNode superNode = getSuperNode(length / 2);
                if (superNode.right == null) return superNode;
                return superNode.right;
            }
        }

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.length = getLength(root);
        }

        //       1
        //    2     3
        // 4   5  6   7
        public int insert(int val) {
            if (length == 0) {
                this.root = new TreeNode(0);
                this.length = 1;
                return -1;
            }
            TreeNode node = getSuperNode(length + 1);
            TreeNode subNode = new TreeNode(val);
            if (node.left == null) {
                node.left = subNode;
            } else {
                node.right = subNode;
            }
            ++length;
            return (Integer) node.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);

        treeNode1.left = treeNode2;
        Leetcode919.CBTInserter cbtInserter = new Leetcode919.CBTInserter(treeNode1);
        System.out.println(cbtInserter.insert(3));
        System.out.println(cbtInserter.insert(4));
        System.out.println(cbtInserter.insert(5));
        System.out.println(cbtInserter.insert(6));
        System.out.println(cbtInserter.insert(7));
        System.out.println(cbtInserter.insert(8));
        TreeNode root = cbtInserter.get_root();
        System.out.println(root);
    }

}