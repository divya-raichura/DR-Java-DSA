public ListNode reverseBetween(ListNode head, int left, int right) {
//   https://leetcode.com/problems/reverse-linked-list-ii
//   question that was difficult few months back... done correct in 30mins
        ListNode matha = new ListNode();
        ListNode dummy = matha;
        dummy.next = head;
        ListNode h;
        ListNode t;
        
        ListNode leftnode = get(head, left);
        ListNode rightnode = get(head, right);
        
        if(left == 1) {
            h = null;
        } else {
            h = get(head, left - 1);
            h.next = null;
        }
        t = rightnode.next;
        rightnode.next = null;
        
        ListNode newHead = reverse(leftnode);
        
        if(h != null) {
            h.next = newHead;
        }
        
        ListNode temp = newHead;
        while(temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = t;
        
        if(h == null) {
            return newHead;
        } else {
            return matha.next;
        }
    }
    
    static ListNode get(ListNode head, int ind) {
        for(int i = 1; i < ind; i++) {
            head = head.next;
        }
        return head;
    }
    
    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        
        return prev;
    }
