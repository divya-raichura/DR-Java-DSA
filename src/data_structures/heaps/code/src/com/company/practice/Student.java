package com.company.practice;

public class Student implements Comparable<Student> {
    int rno;
    int age;

    public Student(int rno, int age) {
        this.rno = rno;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
