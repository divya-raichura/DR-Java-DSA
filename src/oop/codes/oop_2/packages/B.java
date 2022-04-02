package src.oop.codes.oop_2.packages;

import src.oop.codes.oop_2.nayaPackage.A;

public class B {
    public static void main(String[] args) {
        A obj = new A();
        obj.msg();
//        A.msg(); // only if static likha hai like below, warna static ke bina upar wala use karke
//        public static void msg() {
//            System.out.println("hello ");
//        }
    }
}
