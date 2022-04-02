package src.codes.oop.codes.oop_1;

public class Expi {
    public static void main(String[] args) {
        D s1 = new D();
        D s2 = new D(50);
        System.out.println(s2.rno);
        System.out.println(s1.rno);
    }
}

class D { // agar ye niche do value initialize kiya toh debug ke time,
    // pehle constuctor ko chuuta fir idar ata fir constuctor ke andar jata
    int rno;
    String name;

    D() {
        System.out.println("Hello " + name);
    }
    D (int x) {
        System.out.println("the no is: " + x);
        rno = x;
    }
}
