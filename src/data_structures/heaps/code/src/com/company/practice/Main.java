package com.company.practice;

import com.company.GenericPQ;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student(20, 12);
        Student s2 = new Student(50, 14);
        Student s3 = new Student(30, 15);
        Student s4 = new Student(60, 17);

        GenericPQ<Student> pq = new GenericPQ<>();
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);
        pq.add(s4);
    }


}
