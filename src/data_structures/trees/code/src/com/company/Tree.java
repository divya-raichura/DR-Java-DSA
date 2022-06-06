package com.company;

import java.util.*;

public class Tree {
    private Node root;

    void bstInsert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        bstInsert(root, value);
    }

    private void bstInsert(Node node, int value) {
        if (node.val == value) {
            System.out.println("value already exists");
            return;
        }
        if (value > node.val) {
            if (node.right == null) {
                node.right = new Node(value);
                return;
            }
            bstInsert(node.right, value);
        }
        if (value < node.val) {
            if (node.left == null) {
                node.left = new Node(value);
                return;
            }
            bstInsert(node.left, value);
        }
    }

    void preorder() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    void postorder() {
        postorder(root);
    }

    private void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }


    void levelOrder() {
        if (root == null) {
            System.out.println("root is null");
            return;
        }

        levelOrder1(root);
    }

    private List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> sublist = new ArrayList<>();
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            list.add(sublist);
        }
        return list;
    }


// time complexity is bigo of n for all cases
// space complexity is due to queue, and space comp is max memory used
//    for degenerate tree it is best: constant as only one element will be at max in the queue
//    for perfect trees it is worst : bigo of n
    private void levelOrder1(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.peek();
            System.out.println(current.val);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            queue.remove();
        }
    }


    private void preorderIterative(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek().val);
            if (stack.peek().right != null) stack.push(stack.peek().right);
            if (stack.peek().left != null) stack.push(stack.peek().left);
            stack.pop();
        }
    }

    private List<Integer> inorderIterative(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Node node = root;
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                list.add(stack.peek().val);
                node = stack.peek().right;
                stack.pop();
            }
        }
        return list;
    }

    private List<Integer> postorderIterative2Stack(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        Stack<Node> ans = new Stack<>();
        Node node = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            Node popped = stack.pop();
            if (popped.left != null) stack.push(popped.left);
            if (popped.right != null) stack.push(popped.right);
            ans.push(popped);
        }

        for (int i = 0; i < ans.size(); i++) {
            list.add(ans.pop().val);
        }
        return list;
    }

    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
