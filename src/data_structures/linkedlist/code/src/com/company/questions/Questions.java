package com.company.questions;


import java.util.List;

public class Questions {



    public Node recursionInsert(int val, int index, Node node) {
        if (index == 0) {
            return new Node(val, node);
        }

        node.next = recursionInsert(val, index - 1, node.next);
        return node;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode list = head;
        while (list.next != null) {
            if (list.val == list.next.val)
                list.next = list.next.next;
            else
                list = list.next;
        }

        return head;
    }


    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);
        ListNode temp = tempHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }
        return tempHead.next;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public int cycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int l = 0;
                do {
                    temp = temp.next;
                    l++;
                } while (temp != slow);
                return l;
            }
        }
        return 0;
    }

    public ListNode startOfLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return slow; // or temp
            }
        }
        return null;
    }

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            fast = square(square(fast));
            slow = square(slow);
        } while (fast != slow);
        return fast == 1;
    }

    private int square(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += (rem * rem);
            n /= 10;
        }
        return ans;
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    /* recursive solution */
    public ListNode reverseList(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {

        if (head == null) // 1st approach, efficient
            return newHead;
        ListNode future = head.next;
        head.next = newHead;
        return reverseListInt(future, head);
        /*  --> second approach, not that efficient
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
         */
    }

    public ListNode reverseIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode now = head;
        ListNode future = head.next;
        while (now != null) {
            now.next = prev;
            prev = now;
            now = future;
            if (future != null) {
                future = future.next;
            }
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        if (left == right) return head;

        ListNode dummy = new ListNode(0);

        ListNode t1;
        ListNode t2;

        ListNode past = dummy;
        ListNode present = head;
        ListNode future = head.next;
        int count = 1;

        while (count != left) {
            past = present;
            present = future;
            future = future.next;
            count++;
        }

        t1 = past;
        t2 = present;
        while (count != right) {
            past = present;
            present = future;
            future = future.next;
            present.next = past;
            count++;
        }

        present.next = past;
        t1.next = present;
        t2.next = future;

        if (left == 1) {
            return dummy.next;
        }
        return head;
    }


    // see leetcode solution section if you struggle with this
    // its simple, prev = dummy and curr = head, move ahead till curr != m
    // stop when curr at m and prev one before m
    // t1 points one node before left(m) ie at prev
    // t2 points to left(m) ie at curr
    // then we move and reverse curr and prev till prev != n
    // now, stop when prev is at n. now, prev points to right(n)
    // link t1 with prev and t2 with curr
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int i = 1;
        ListNode curr = head;
        ListNode prev = dummy;

        while (i < m) {
            prev = curr;
            curr =curr.next;
            i++;
        }

        ListNode t1 = prev;
        ListNode t2 = curr;

        while (i <= n) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }
        t1.next = prev;
        t2.next = curr;
        return dummy.next;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode mid = getMid(head);
        ListNode start = head;
        ListNode temp = reverse(mid);
        while(temp != null){
            if(temp.val != start.val) {
                return false;
            }
            start = start.next;
            temp = temp.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode past = null;
        ListNode present = head;
        ListNode future = head.next;

        while(present != null){
            present.next = past;
            past = present;
            present = future;
            if(future != null){
                future = future.next;
            }
        }

        return past;
    }

    public void reorderList(ListNode head) {

        if(head == null || head.next == null) return;

        ListNode mid = getMid2(head);

        ListNode head1 = head;
        ListNode head2 = reverse2(mid);

        while(head2 != null) {
            ListNode l1 = head1.next;
            ListNode l2 = head2.next;

            head1.next = head2;
            if(l1 == null){
                break;
            }
            head2.next = l1;

            head1 = l1;
            head2 = l2;
        }

    }

    public ListNode reverse2(ListNode head){
        ListNode past = null;
        ListNode present = head;
        ListNode future = head.next;
        while(present!=null){
            present.next = past;
            past = present;
            present = future;
            if(future!=null){
                future = future.next;
            }
        }
        return past;
    }

    public ListNode getMid2(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }


    public void reverseKGroup(int k) {
        reverseKGroup(head, k);
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode t = head;
        int size = 0;
        while (t != null) {
            t = t.next;
            size++;
        }

        int newK = size / k;
        int count = 0;
        ListNode t2 = head;
        ListNode preDummy = new ListNode(0);
        ListNode newHead = new ListNode(0);
        while (count < newK) {
            ListNode t1 = t2;
            ListNode dummy = t2;
            int pointer = 1;
            while (pointer < k) {
                t1 = t1.next;
                pointer++;
            }
            ListNode prev = null;
            ListNode curr = t2;
            while (prev != t1) {
                t2 = t2.next;
                curr.next = prev;
                prev = curr;
                curr = t2;
            }
            if (count == 0) {
                ListNode temp = t1;
                newHead.next = temp;
            }
            if (dummy != null) {
                dummy.next = t2;
            }
            preDummy.next = t1;
            preDummy = dummy;
            count++;
        }
        return newHead.next;
    }


    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0) return head;
        ListNode t2 = head;
        int size = 1;
        while (t2.next != null) {
            t2 = t2.next;
            size++;
        }
        t2.next = head;
        int newK = k % size;
        int count = 0;
        int cut = size - newK;
        while (count < cut) {
            t2 = t2.next;
            count++;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = t2.next;
        t2.next = null;
        return newHead.next;

    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }


    
    // leetcode solution 1
    // https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!

    // above link is the best solution for intersection
    // below solution is also good, easy to understand
    // leetcode solution 2
    public ListNode getIntersectionNodeLeet(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {



        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;

        ListNode t1 = headA;
        ListNode t2 = headB;
        int len1 = length(headA);
        int len2 = length(headB);
        
        int max = 0;
        ListNode temp;
        if (len1 > len2) {
            max = len1 - len2;
            temp = headA;
            t2 = headB;
            while(max > 0){
                temp = temp.next;
                max--;
            }
            while(temp != t2) {

                temp = temp.next;
                t2 = t2.next;
            }
            return t2;
        }
        else {
            max = len2 - len1;
            temp = headB;
            t1 = headA;
            while(max > 0){
                temp = temp.next;
                max--;
            }
            while(temp != t1) {

                temp = temp.next;
                t1 = t1.next;
            }
            return t1;
        }

        // return null;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) { // when no value is provided for Node, this means
            // by default it will have 'null' as it is object type, not primitive
            this.value = value;
        }
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public void insertFirst(int val) {
        ListNode node = new ListNode(val);

        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void display() {  // o(n)
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next; // not head.next
        }
        System.out.println("END");
    }


    public static void main(String[] args) {
        Questions list = new Questions();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.reverseKGroup(3);
        list.display();
    }
}
