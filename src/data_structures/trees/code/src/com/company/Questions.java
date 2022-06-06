package com.company;

import java.util.*;

public class Questions {

//    iterative all solutions simple : https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
//    for postorder see there in comments

    // PREORDER
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderRec(root, list);
        return list;
    }

    private void preorderRec(TreeNode node, List<Integer> list){
        if (node == null) return;
        list.add(node.val);
        preorderRec(node.left, list);
        preorderRec(node.right, list);
    }

    private List<Integer> preorderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }


    // INORDER
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderIterative(root);
    }

    private void inorderRec(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderRec(node.left, list);
        list.add(node.val);
        inorderRec(node.right, list);
    }

    private List<Integer> inorderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }


    // POSTORDER
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderRec(root, list);
        return list;
    }

    private void postorderRec(TreeNode node, List<Integer> list) {
        if (node == null) return;
        postorderRec(node.left, list);
        postorderRec(node.right, list);
        list.add(node.val);
    }

    private List<Integer> postorderIterative(TreeNode node) {
        // see lecture and leetcode solution(of comments) in above link
        return new ArrayList<>();
    }

    private List<Integer> postorder2Stacks(TreeNode root) {
        // see striver lecture
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode node;
        if (root == null) return list;
        s1.push(root);
        while (!s1.isEmpty()) {
            node = s1.pop();
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
            s2.push(node);
        }
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        return list;
    }


    // LEVEL ORDER
    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrderHelper(root);
    }

    private List<List<Integer>> levelOrderHelper(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null) return ans;
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                list.add(node.val);
            }
            ans.add(list);
        }
        return ans;
    }

    // MAX DEPTH
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root);
    }

    private int maxDepthHelper(TreeNode node) {
        if (node == null) return 0;
        int left = maxDepthHelper(node.left);
        int right = maxDepthHelper(node.right);

        return Math.max(left,right) + 1;
    }

    // BALANCED?
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) != -2;
    }

    public int isBalancedHelper(TreeNode node) {
        if (node == null) return -1;
        int l = isBalancedHelper(node.left);
        if (l == -2) return -2;
        int r = isBalancedHelper(node.right);
        if (r == -2) return -2;
        if (Math.abs(l - r) > 1) return -2;
        return 1 + Math.max(l, r);
    }

    // DIAMETER?
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = {Integer.MIN_VALUE};
        diameterOfBinaryTreeHelper(root, diameter);
        return diameter[0];
    }

    public int diameterOfBinaryTreeHelper(TreeNode node, int[] d) {
        if (node == null) return 0;
        int l = diameterOfBinaryTreeHelper(node.left, d);
        int r = diameterOfBinaryTreeHelper(node.right, d);
        d[0] = Math.max(d[0], l + r);
        return 1 + Math.max(l, r);
    }


    // MAX PATH SUM
    public void maxPathSum(TreeNode root) {
        // will do later
    }


    // SAME TREE?
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
    // 2ND APPROACH -> shorter, not different than 1st one
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null || q == null) return (p == q);
        return p.val == q.val && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }

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

}
