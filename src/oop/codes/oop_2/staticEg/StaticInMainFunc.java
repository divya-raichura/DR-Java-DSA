package src.oop.codes.oop_2.staticEg;



// watch
// https://www.youtube.com/watch?v=_Ya6CN13t8k&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=39&t=932s&ab_channel=KunalKushwaha
// from 40mins
// for understanding the concept


public class StaticInMainFunc { // suppose the name of class is Main
    public static void main(String[] args) {
        // we can access or modify static variables without referencing or creating an obj
        // we can declare functions/methods as static as well and psvm is a common eg for this

        // why is main declared as static
        // because static means we can use main method without creating object of that class
        // and main is first thing that runs in java and if we hide psvm, we
        // will not be able to run this file

        // so main is the first thing that will run then if you don't put it
        // as static, obv to run anything inside a class you have to create
        // obj of that class to access any instance var/method
        // how can you create obj and run the program to create an obj if main is
        // the very first thing running, hence u shud be able to run main without
        // creating any object  of the class in which main is. Hence, main method is static



        // so before any obj or anything is created it shud allow us to run
        // psvm and hence psvm has static

        // HENCE THIS STATIC VARIABLE OR STATIC METHODS, BELONG TO
        // THE CLASS AND NOT THE OBJECT
//        greeting(); // error
    }

    // you can't have non-static member inside a static but vice versa is true


    static void fun() {
        // this is independent of obj as it is static
        // does not belong to an instance
//        greeting(); // you can't use this here as it requires an instance
        // but the function you are using it in does not depend on instance

        // in simple words, fun does not depend on instances then how can
        // you have something in it that depends on instances

        StaticInMainFunc obj = new StaticInMainFunc();
        obj.greeting();// you cannot access non static stuff without referencing their instances
        // in a static context
        // hence here we referenced it
        // watch from  40mins to see great example and understand all things
    }

    // belongs to an instance
    // this is dependent of objects as it does not have static
    void greeting() { // if we don't write static, we can't use(call) this
        // inside psvm
        // that is, inside a static method, you cannot use anything that is not static
        System.out.println("Hello World");
        // so, a static method can access only static data, as
        // a non-static data belongs to an instance(belongs to an obj)
        // fun() // this is ok
    }
}
