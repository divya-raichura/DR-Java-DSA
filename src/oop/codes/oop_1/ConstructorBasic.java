package src.oop.codes.oop_1;
// https://www.javatpoint.com/java-constructor
public class ConstructorBasic {
    public static void main(String[] args) {

//        In Java, a constructor is just like a method but without return type. It can
//        also be overloaded like Java methods.

        Stud2 s = new Stud2(52, "Divya");
        s.display();
        Stud2 ss = new Stud2(54, "Vikas");
        ss.display();
    }
}

class Stud2 {
    int rno;
    String name;

    Stud2(int r, String n) {
        rno = r;
        name = n;
    }

    void display() {
        System.out.println("roll no: " + rno + " name: " + name);
    }
}


class Abc {
    int rno;

    Abc() {
        this.rno = 19;
    }
}