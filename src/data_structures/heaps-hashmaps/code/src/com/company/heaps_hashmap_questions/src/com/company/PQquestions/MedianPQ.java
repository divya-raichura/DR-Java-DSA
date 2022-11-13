package com.company.questions;

import java.sql.ClientInfoStatus;
import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPQ {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPQ() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void add(int val) {
        if (right.size() > 0 && val > right.peek()) {
            right.add(val);
        } else {
            left.add(val);
        }
        if (left.size() - right.size() > 1) {
            right.add(left.remove());
        } else if (right.size() - left.size() > 1) {
            left.add(right.remove());
        }
    }

    public int median() throws Exception {
        if (left.size() >= right.size()) {
            if (left.peek() == null) throw new Exception("null");
            return left.peek();
        } else {
            return right.peek();
        }
    }

    public int remove() throws Exception {
        if (left.size() + right.size() ==0) throw new Exception("empty");
        if (left.size() >= right.size()) {
            if (left.peek() == null) throw new Exception("null");
            return left.remove();
        } else {
            return right.remove();
        }
    }
}
