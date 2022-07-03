package com.company;

import java.util.Stack;

public class BST {
    //  kth smallest
    private static int number = 0;
    private static int count = 0;

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
    public TreeNode ceil(TreeNode root, int val) {
        TreeNode ceil = new TreeNode();
        while (root != null) {
            if (root.val == val) {
                ceil = root;
                return ceil;
            }

            if (val < root.val) {
                ceil = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }

    // floor
    public TreeNode floor(TreeNode root, int val) {
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
        if (root == null) return new TreeNode(val);

        if (val > root.val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);

        return root;
    }

    // insert iterative
    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        while (true) {
            if (cur.val <= val) {
                if (cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if (cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    // Delete Node my attempt
    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode node = root;
        TreeNode pre = root;
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode temp = root.left;
                root = temp;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = pre.right;
            }
            return root;
        }

        while (node != null) {
            if (node.val == key) {
                break;
            }
            if (key <= node.val) {
                pre = node;
                node = node.left;
            } else {
                pre = node;
                node = node.right;
            }
        }
        if (node == null) return root;
        if (pre.left == node) {
            if (node.left == null) {
                pre.left = node.right;
            } else {
                TreeNode temp = node.left;
                pre.left = temp;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = node.right;
            }

        } else {
            if (node.left == null) {
                pre.right = node.right;
            } else {
                TreeNode temp = node.left;
                pre.right = temp;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = node.right;
            }
        }
        return root;
    }


    // leetcode solution for kth smallest

    // for iterative see this:-
    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63660/3-ways-implemented-in-JAVA-(Python)%3A-Binary-Search-in-order-iterative-and-recursive

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }

    // kth largest
    public int kthBigger(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
        while (k != 0) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) return node.val;
            TreeNode left = node.left;
            while (left != null) {
                stack.push(left);
                left = left.right;
            }
        }
        return -1;
    }


    // validate bst
    // iterative :-
//    https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (!(node.val > min && node.val < max)) return false;

        return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
    }

    class TreeNode {
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


}
