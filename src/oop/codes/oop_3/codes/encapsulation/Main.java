package src.oop.oop_3.codes.encapsulation;

public class Main {
    private int n;

//    public Main(int n) {
//        this.n = n;
//    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public static void main(String[] args) {

    }
}

class Out {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.setN(12);
        System.out.println(obj.getN());
        Main obj2 = new Main();
        System.out.println(obj2.getN());

//        System.out.println(obj.n); // can't access
        // use set to set the var and get to get it

        OnlyGetter b = new OnlyGetter();
        System.out.println(b.getName());
    }
}

// if the class is only Setter then it is Write only as it only has set method
class OnlyGetter {
    // read only->as it only has get method, we can only read, can't change name
    private String name = "Hello";

    public String getName() {
        return name;
    }
}