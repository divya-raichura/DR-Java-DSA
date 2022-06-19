package com.company;

public class BST {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.make();
    }

    public void make() {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode();
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        searchBSTRec(treeNode, 2);
    }

    // search recursive
    public TreeNode searchBSTRec(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val <= val) return searchBSTRec(root.right, val);
        else return searchBSTRec(root.left, val);
    }

    // search iterative
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val <= val ? root.right : root.left;
        }
        return root;
    }

    // ceil
    public TreeNode ceil(TreeNode root, int val){
        TreeNode ceil = new TreeNode();
        while (root != null) {
            if (root.val == val) {
                ceil = root;
                return ceil;
            }

            if (root.val > val) {
                ceil = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }


    // floor
    public TreeNode floor(TreeNode root, int val){
        TreeNode floor = new TreeNode();
        while (root != null) {
            if (root.val == val) {
                floor = root;
                return floor;
            }

            if (root.val > val) {
                root = root.left;
            } else {
                floor = root;
                root = root.right;
            }
        }
        return floor;
    }

    // insert recursive
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right =  insertIntoBST(root.right, val);
        } else {
            root.left =  insertIntoBST(root.left, val);
        }
        return root;
    }

    // insert iterative
    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode cur = root;
        while(true) {
            if(cur.val <= val) {
                if(cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if(cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

}
