package com.company;

public class AVL {

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        int height;

        public TreeNode(int data) {
            this.data = data;
        }

    }

    private int height(TreeNode node) {
        return node != null ? node.height : -1;
    }

    private void updateHeight(TreeNode node) {
        int l = height(node.left);
        int r = height(node.right);
        node.height = Math.max(l, r) + 1;
    }

    private int bf(TreeNode node) {
        return height(node.right) - height(node.left);
    }

    private TreeNode rotateRight(TreeNode node) {
        TreeNode leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;

        updateHeight(leftChild);
        updateHeight(node);
        return leftChild;
    }

    private TreeNode rotateLeft(TreeNode node) {
        TreeNode rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;

        updateHeight(rightChild);
        updateHeight(node);
        return rightChild;
    }

    private TreeNode rebalance(TreeNode node) {
        int bf = bf(node);

        // left heavy
        if (bf < -1) {
            if (bf(node.left) <= 0) {
                // rotate right                                   // case 1
                node = rotateRight(node);
            } else {
                // rotate left and then right                     // case 2
                node.left = rotateLeft(node);
                node = rotateRight(node);
            }
        }

        // right heavy
        if (bf > 1) {
            if (bf(node.right) >= 0) {
                // rotate left                                   // case 3
                node = rotateLeft(node);
            } else {
                // rotate right and then left                     // case 4
                node.right = rotateRight(node);
                node = rotateLeft(node);
            }
        }
        return node;
    }


    // insert recursive
    public TreeNode insertIntoBST( TreeNode node, int val) {
        if (node == null) return new TreeNode(val);

        if (val > node.data) {
            node.right = insertIntoBST(node.right, val);
        } else {
            node.left = insertIntoBST(node.left, val);
        }

        // once inserted, before going back we update height and send to
        // rebalance to check, correct and make rotations if the tree got unbalanced
        updateHeight(node);
        return rebalance(node);
    }

}
