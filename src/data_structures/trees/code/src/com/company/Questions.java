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

    private void preorderRec(TreeNode node, List<Integer> list) {
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
        while (!stack.isEmpty()) {
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

    // If you want to print
    public void lvl(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            System.out.println(node.val);
        }
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

        return Math.max(left, right) + 1;
    }


    // MIN DEPTH

    // -> BFS is the better approach
    // DFS
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        /*
            if (root == null) {
            return 0;
            }

            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0 || right == 0) {
              return Math.max(left, right) + 1;
            }
            else {
                return Math.min(left, right) + 1;
            }
         */
    }


    // BFS
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) return level;
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            level++;
        }
        return level;
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
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    // 2ND APPROACH -> shorter, not different than 1st one
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null || q == null) return (p == q);
        return p.val == q.val && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }


    // Target Sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int[] d = {0};
        return hasPathSumH(root, targetSum, d);
    }

    // My approach
    public boolean hasPathSumH(TreeNode node, int targetSum, int[] d) {
        if (node == null) return false;

        if (node.left == null && node.right == null) return d[0] + node.val == targetSum;

        d[0] += node.val;
        boolean l = hasPathSumH(node.left, targetSum, d);
        if (l) return true;

        boolean r = hasPathSumH(node.right, targetSum, d);
        if (r) return true;

        d[0] -= node.val;
        return false;
    }

    // LeetCode Recursive
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    // Invert Tree LeetCode

// https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions

    public TreeNode invert(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            TreeNode l = node.left;
            node.left = node.right;
            node.right = l;
        }
        return root;
    }


    // zig zag level order traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    level.add(0, node.val);
                }
                else {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }

    // Symmetric Tree

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricRec(root.left, root.right);
    }

    // Recursion
    public boolean isSymmetricRec(TreeNode left, TreeNode right) {
        if (left ==null || right == null) return left == right;
        return left.val == right.val && isSymmetricRec(left.left, right.right) && isSymmetricRec(left.right, right.left);
    }

    // Iterative
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode l = stack.pop(), r = stack.pop(); // stack can store null
            if (l == null && r == null) continue;
            if (l == null || r == null || l.val != r.val) return false;
            stack.push(l.left);
            stack.push(r.right);
            stack.push(l.right);
            stack.push(r.left);
        }
        return true;
    }

    // Paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        binaryTreePathsHelper("", ans, root);
        return ans;
    }

    // string (inefficient)
    public void binaryTreePathsHelper(String path, List<String> list, TreeNode node) {
        if (node.left == null && node.right == null) list.add(path + node.val);

        if (node.left != null) binaryTreePathsHelper(path + node.val + "->", list, node.left);

        if (node.right != null) binaryTreePathsHelper(path + node.val + "->", list, node.right);
    }


    // string builder
    public List<String> binaryTreePathsSB(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) return ans;
        binaryTreePathsHelperSB(ans, root, sb);
        return ans;
    }

    private void binaryTreePathsHelperSB(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) return;

        int len = sb.length();
        sb.append(root.val);

        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            if (root.left != null) binaryTreePathsHelperSB(res, root.left, sb);
            if (root.right != null) binaryTreePathsHelperSB(res, root.right, sb);
        }
        sb.setLength(len);
    }

    // ROOT TO NODE (for only leaf, not any node)
    public boolean path(TreeNode node, TreeNode target, List<Integer> list) {
        if (node == null) return false;

        if (node.left == null && node.right == null) {
            if (node.val != target.val) return false;
            list.add(node.val);
            return true;
        }

        list.add(node.val);
        boolean l = path(node.left, target, list);
        if (l) return true;
        boolean r = path(node.right, target, list);
        if (r) return true;
        list.remove(list.size() - 1);
        return false;
    }

    // For path to any target node
    public boolean getPath(TreeNode node, int target, List<Integer> list) {
        if (node == null) return false;

        list.add(node.val);

        if (node.val == target) return true;

        if (getPath(node.left, target, list) || getPath(node.right, target, list)) return true;

        list.remove(list.size() - 1);

        return false;
    }

    public void make() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        lowestCommonAncestorOp(root, root.left, root.right);
    }

    // LCA -> brute force
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (root.left == null && root.right == null)) return root;
        List<TreeNode> a = new ArrayList<>();
        lowestCommonAncestorHelper(root, p.val, a);
        List<TreeNode> b = new ArrayList<>();
        lowestCommonAncestorHelper(root, q.val, b);
        for (int i = a.size() - 1; i >=0  ; i--) {
            for (int j = b.size()-1; j >= 0  ; j--) {
                if (a.get(i).val == b.get(j).val) return a.get(i);
            }
        }
        return root;
    }

    // helper for solution 1 (bruteforce solution)
    public boolean lowestCommonAncestorHelper(TreeNode node, int target, List<TreeNode> list) {
        if (node == null) return false;
        list.add(node);
        if (node.val == target) return true;
        if (lowestCommonAncestorHelper(node.left, target, list) || lowestCommonAncestorHelper(node.right, target, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

    // LCA -> optimised
    public TreeNode lowestCommonAncestorOp(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;

        if (node.val == p.val) return p;
        if (node.val == q.val) return q;

        TreeNode l = lowestCommonAncestorOp(node.left, p, q);
        TreeNode r = lowestCommonAncestorOp(node.right, p, q);

        if (l == null && r == null) return null;

        if (l == null) return r;

        if (r == null) return l;

        return node;
        /*
        striver's optimised code
        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
         */
    }

    // MAX WIDTH
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int width = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int nmin = queue.peek().index; // min index of a level
            int first = 0 , last = 0;
            for (int i = 0; i < size; i++) {
                Pair pop = queue.poll();
                int curr_id = pop.index - nmin;
                if (i == 0) first = curr_id;
                if (i == size - 1) last =  curr_id;
                if (pop.node.left != null) {
                    queue.offer(new Pair(pop.node.left, 2 * curr_id + 1));
                }
                if (pop.node.right != null) {
                    queue.offer(new Pair(pop.node.right, 2 * curr_id + 2));
                }
            }
            width = Math.max(width, last - first + 1);
        }
        return width;
    }

    public class Pair{
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
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

    public static void main(String[] args) {
        String a = "->";
        System.out.println(a + 2);
        Questions tree = new Questions();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.remove(list.size() - 1);
        tree.make();
    }

}
