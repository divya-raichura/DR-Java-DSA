package src.oop.oop_4.code.object_overridingMethods;



public class ObjectDemo {
    int num;

    public ObjectDemo(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        return this.num == ((ObjectDemo)obj).num;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // if we modify to num, we will get num when we
        // call this method objName.hashCode()
    }

    public static void main(String[] args) {
//        Object obj1 = new Object();
//        System.out.println(obj1.hashCode());

//        ObjectDemo obj2 = new ObjectDemo(); // empty hai fir bhi hashcode deta h
//        // empty matlab class me hi koi var nai banaya
//        System.out.println(obj2.hashCode());
//
//        ObjectDemo obj3 = new ObjectDemo();
//        System.out.println(obj3.hashCode()); // different values of empty wala eg

//        ObjectDemo obj2 = new ObjectDemo(24);
//        System.out.println(obj2.hashCode());
//
//        ObjectDemo obj3 = new ObjectDemo(24);
//        System.out.println(obj3.hashCode());
//
//        ObjectDemo obj4 = new ObjectDemo(13);
//        System.out.println(obj4.hashCode());

        // it gives different for all obj1,2,3,4 as it is not dependent on the
        // number passed
        // it is not address, can't get address in java!!!

        ObjectDemo obj1 = new ObjectDemo(12);
        ObjectDemo obj2 = new ObjectDemo(12);
        // these gives false for both == and equals


//        ObjectDemo obj2 = obj1; // this will give true for both
        obj2.num = 123;
        System.out.println(obj1 == obj2);
        System.out.println(obj1.equals(obj2));

        // if we want to put our own rule to print if content is equal or not
        // here wkt it is, as both have '12' value
        // we can do it via overriding the equals method

        // I did it, but don't know why that typecasting
        // tho, after it, System.out.println(obj1.equals(obj2)); will print true
        // as now it will check if values are equal or not

        // getClass
        System.out.println(obj1.getClass());
//        System.out.println(obj1.getClass().getConstructors()); // says to wrap around Arrays.toString
        // let's experiment in new file
    }
}
