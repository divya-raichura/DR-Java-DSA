package src.oop.codes.oop_2.staticEg;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population; // common for all objects(humans) in human class, hence static
    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population += 1; // whenever a new human(obj) is created, population increases by one
        // but as it is not static, so the value comes out to be one for every obj
        // now after using static, it is common for all, so we don't need
        // to use this.population, instead, we can
        // use the class name here as well as while calling a static variable
        // this. will also work but using classname. is the convention
    }

    static void fun() {
        System.out.println("hello world");
//        System.out.println(this.age); // can't use this. in static method
        // as static does not depend on obj and we can't use things that depend
        // on obj inside static and as this. depends, we can't use it

    }
}
