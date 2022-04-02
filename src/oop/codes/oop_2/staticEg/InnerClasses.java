package src.oop.codes.oop_2.staticEg;
// class inside a class

// outside classes cannot be static as it is not dependent on other class
public class InnerClasses {// this class is outside, hence it is not static
    static class Test { // inner-classes like this one can be static as it can be depended on outer class
// when it is like this, without static, it is dependent on outer class

        static String name;

        public Test(String name) {
            Test.name = name;
        }
    }
    public static void main(String[] args) {
//        Test obj1 = new Test("Divya");// error jo pehle likha tha uske liye uske bad update kardiya
//        Test obj2 = new Test("Kunal");// as psvm is static and so you can't have anything from outside which is not static
//        System.out.println(Test.name);
//        System.out.println(Test.name);
//        System.out.println(Test.name == Test.name);
        // it will work fine if u put class test outside but if it is inside then it will depend on other class
        // but what if we make it static --> in innerclass2 file
    }
}
//Static class A{
         // error- outside classes cannot be static
         // as it is itself not dependent on any other class hence we can't
         // put static
//}

