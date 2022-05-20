package com.company;

import java.util.NoSuchElementException;

class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) { // o(1)
        Node node = new Node(val); // create new node having asked value

        node.next = head; // this new node points to node where head is pointing to
        // initially, head is pointing to null so new node will also point to null,
        // but when there are already elements, new node will point to that first
        // node but head needs to be changed now in any case this or initial...

        head = node; // make that head point to this new node as this new node became
        // first element and head always points to first element

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val) { // o(1)
        // if this tail(extra var) was not there, we would have to
        // traverse through arr like display which would take o(n)
        // so this is the benefit of taking tail

        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    // my method
    public void insertMid(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node node = new Node(val);
        Node temp1 = head;
        Node temp2 = head.next;

        int count = 1;
        while (count != index) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            count++;
        }

        temp1.next = node;
        node.next = temp2;
        size++;
    }

    // after clicking by watching lec
    public void insertMid2(int val, int index) {
        if (index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;

        int count = 1;
        while (count != index) {
            temp = temp.next;
            count++;
        }

        Node node = new Node(val, temp.next);
        //        node.next = temp.next; // this can be done by directly passing next in the constructor
        // like this Node node = new Node(val, temp.next);

        temp.next = node;

        // more optimisation temp.next = new Node(val, temp.next);
        size++;
    }

    public Node find(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        display();
    }

    public void remove(int index) {
        if (index <= 0) {
            removeFirst();
        }
        if (index == size - 1) {
            removeLast();
        }

//   to remove an element, we need element before it, hence index-1
        Node temp = getNode(index - 1);
        temp.next = temp.next.next;
        size--;
        display();
    }

    public void removeLast() { // o(n)
        if (head == null)
            throw new NoSuchElementException();
        if (size <= 1) {
            removeFirst();
        }

        // to remove last element, we need element before it, hence size-2
        Node secondLast = getNode(size - 2); // size-1 is the last node
        tail = secondLast;
        tail.next = null;
        size--;
        display();
    }

    public Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {  // o(n)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next; // not head.next
        }
        System.out.println("END");
    }

    // 2

    public void insertRec(int val, int index) {
        if (index > size) {
            System.out.printf("Index out of bound : Size %d Index: %d\n", size, index);
            return;
        }
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node); // temp.next = node (current node)
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    // questions
    public Node removeDup() {

        /*
        public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode list = head;
         while(list.next != null)
         {
             if (list.val == list.next.val)
                 list.next = list.next.next;
             else
                 list = list.next;
         }

         return head;
    }
         */

        if (head == null || head.next == null) return head;

        Node temp1 = head;
        Node temp2 = head.next;

        while (temp2 != null) {
            if (temp1.value == temp2.value) {
                while (temp1.value == temp2.value) {
                    temp2 = temp2.next;
                    if (temp2 == null) {
                        break;
                    }
                }
                temp1.next = temp2;
                temp1 = temp2;
                if (temp2 != null) {
                    temp2 = temp2.next;
                }
            } else {
                while (temp1.value != temp2.value) {
                    temp1 = temp2;
                    temp2 = temp2.next;
                    if (temp2 == null) {
                        break;
                    }
                }
            }
        }
        return head;
    }

    public Node merge(Node l1, Node l2) {
        Node tempHead = new Node(0);
        Node temp = tempHead;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
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

    public boolean hasCycle() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public int cycleLength() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // cycle is present, hence find length
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    public Node startOfLoop() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                Node temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }



    // google question
    // https://leetcode.com/problems/happy-number/
    public boolean happy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = square(slow);
            fast = square(square(fast));
        } while (fast != slow);

        // it will always reach fast == slow, whether number will become 1 or not
        // because if it becomes '1' then it will keep doing 1 square which is '1' only
        // otherwise it is cycle so will meet slow somewhere

        return slow == 1;
    }


    public int square(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans = ans + (rem * rem);
            n /= 10;
        }
        return ans;
    }

    public Node getMid(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // we need to break the link between mid and it's prev

        // step 2. sort each half
        ListNode l1 = sortList(head); // head to mid-1
        ListNode l2 = sortList(slow); // mid to end

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }

    public void reverse() {
//        tail = reverse(head);
        revWithTail(head);
    }

    private Node reverse(Node node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            head = node;
            return node;
        }

        Node temp = reverse(node.next);
        temp.next = node;
        node.next = null;
        return node;
    }

    public void revWithTail(Node node) {
        if (node.next == null) {
            head = tail;
            return;
        }
        revWithTail(node.next);
        tail.next = node;
        tail = node;
        node.next = null;
    }

    public Node reverseIterative() {

        if (head == null || head.next == null) return head;

        Node past = null;
        Node present = head;
        Node future = head.next;

        while (present != null) {
            present.next = past;
            past = present;
            present = future;
            if (future != null) {
                future = future.next;
            }
        }
        head = past;
        return past;
    }

    public Node reverseIndex(int left, int right) {

        /*


        // leetcode solution, more simplified


        public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode curr = fakeHead.next;
        int i = 1;
        while (i < m) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode node = prev;
        while (i <= n) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            i++;
        }
        node.next.next = curr;
        node.next = prev;
        return fakeHead.next;
    }
         */

        if (head == null || head.next == null) return head;

        if (left == right) return head;

        Node dummy = new Node(0);

        Node t1;
        Node t2;

        Node past = dummy;
        Node present = head;
        Node future = head.next;
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

        t1.next = present;
        t2.next = future;

        if (left == 1) {
            return dummy.next;
        }
        return head;
    }


    public void palin() {
        /*
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

    public ListNode getMid(ListNode head) {

         ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
         */
    }

    public void reorderList(ListNode head) {
        /*
        public void reorderList(ListNode head) {

        if(head == null || head.next == null) return;

        ListNode prevMid = getMid(head);
        ListNode mid = prevMid.next;
        prevMid.next = null;

        ListNode head1 = head;
        ListNode head2 = reverse(mid);

        while(head1 != null) {
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

    public ListNode reverse(ListNode head){
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

    public ListNode getMid(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return prev;
    }
         */
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||head.next==null||k<2) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy, prev = dummy,temp;
        int count;
        while(true){
            count =k;
            while(count>0&&tail!=null){
                count--;
                tail=tail.next;
            }
            if (tail==null) break;//Has reached the end


            head=prev.next;//for next cycle
            // prev-->temp-->...--->....--->tail-->....
            // Delete @temp and insert to the next position of @tail
            // prev-->...-->...-->tail-->head-->...
            // Assign @temp to the next node of @prev
            // prev-->temp-->...-->tail-->...-->...
            // Keep doing until @tail is the next node of @prev
            while(prev.next!=tail){
                temp=prev.next;//Assign
                prev.next=temp.next;//Delete

                temp.next=tail.next;
                tail.next=temp;//Insert

            }

            tail=head;
            prev=head;

        }
        return dummy.next;

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


}
