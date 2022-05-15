package src.oop.codes.oop_6.toString_;

public class Students implements Comparable<Students>{
    String name;
    int marks;
    int rno;

    public Students(String name, int marks, int rno) {
        this.name = name;
        this.marks = marks;
        this.rno = rno;
    }

    @Override
    public String toString() {
        return this.name +" -> " + this.marks;
    }

    @Override
    public int compareTo(Students o) {
        return Integer.compare(this.marks, o.marks);
    }
}
