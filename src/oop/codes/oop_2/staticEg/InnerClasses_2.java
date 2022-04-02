package src.oop.codes.oop_2.staticEg;

//class Test { // this is outside innerclass_2 so it is not dependent and we can use it
//    // if we put inside innerclass_2, to use test we need to put static
//     String name; // static hua toh dono jagah kunal print hoga warna alag alag
//
//    public Test(String name) {
//        this.name = name;
//    }
//}

public class InnerClasses_2 {
//    static class Test { // this is inside now, so it is dependent on outside class
//        // to use test we need to put static
//        // so that it will depend on class itself on not upon its object
//         static String name;
//           ---->>> agar aisa kiya toh fir kunal hi print hoga dono bar
//
//        public Test(String name) {
//            Test.name = name;
//        }
//    }
    static class Test { // this is inside now, so it is dependent on outside class
        // to use test we need to put static
        // so that it will depend on class itself on not upon its object
         String name;
        public Test(String name) {
            this.name = name;
            // --->>> now alag alag print hoga
        }
    }

    public static void main(String[] args) {
        Test obj1 = new Test("Divya"); // name = divya
        Test obj2 = new Test("Kunal");// name will become kunal from divya
        System.out.println(obj1.name); // both will print kunal
        System.out.println(obj2.name);
    }
}
