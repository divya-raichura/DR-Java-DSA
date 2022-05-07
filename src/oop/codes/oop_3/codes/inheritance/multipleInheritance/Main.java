package src.oop.oop_3.codes.inheritance.multipleInheritance;

public class Main {
    public static void main(String[] args) {

//        Box box1 = new Box(); // as here constructor is empty, it calls empty cons in Box class
//        System.out.println(box1.l + " " + box1.b + " " + box1.h);

//          you can't access child class property ie weight from parent class 'Box'
//          box1.weight is error
//        but vise versa is true

//        Box box2 = new Box(4); // depending upon arguments, it calls the required constructor
//        System.out.println(box2.l + " " + box2.b + " " + box2.h);
//
//        Box box3 = new Box(5, 6, 7); // depending upon arguments, it calls the required constructor
//        System.out.println(box3.l + " " + box3.b + " " + box3.h);
//
//        Box box4 = new Box(box3); // now it calls constructor having box data type
//        System.out.println(box4.l + " " + box4.b + " " + box4.h);

//        BoxWeight box1 = new BoxWeight();
//        System.out.println(box1.l + " " + box1.weight);

        // what if we want to use all properties- l,b,h,weight inside the constructor
        // ie we want like this-         BoxWeight box2 = new BoxWeight(2,3,5,6);
        // for that we make a constructor in child class and use the "Super" keyword
//        BoxWeight box2 = new BoxWeight(8, 9, 10);
//        System.out.println(box2.l + " " + box2.b + " " + box2.h);
        // NOTE: if l was private in Box class, 'private double l' then we won't be able to use it here
//        BoxWeight s = new BoxWeight(box2);

        BoxPrice s = new BoxPrice(); // this is the last class in the chain so it can
//        access all variables and methods of all the classes above it
        System.out.println(s.price);

        BoxPrice x = new BoxPrice(s); // this is the last class in the chain so it can
        System.out.println(x.price);

    }
}
