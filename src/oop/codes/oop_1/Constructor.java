package src.codes.oop.codes.oop_1;

// https://www.javatpoint.com/java-constructor

public class Constructor {
    public static void main(String[] args) {
// A constructor is called "Default Constructor" when it doesn't have any parameter.
        Stud s1 = new Stud();
 // Every time an object is created using the new() keyword, at least one constructor is called.
//        ie  It is called when an instance of the class is created.
 // If there is no constructor in a class, compiler automatically creates a default constructor.

//  instead of initializing by reference method as below, we use constructor
        s1.rno = 99;
        s1.name = "modi";
        s1.marks = 24.5f;

        System.out.println(s1.rno);
        System.out.println(s1.name);
        System.out.println(s1.marks);

        new Stud().greeting();


    }
}

class Stud {
    int rno = 2;
    String name = "divya";
    float marks = 20.2f;

    void greeting() {
        System.out.println("Hello " + this.name);
    }

//     you don't have to write name or return type, return type is the class itself because
//     its going to create the type of the obj of the class
    Stud () {

        // below lines give error as this is a template, it doesn't know what is s1

//        s1.rno = 11;
//        s1.name = "kunal kushwaha";
//        s1.marks = 99.12f;


        //  we need a way to add values of above properties obj by obj, like for every obj
        //  it should be different so, we need one word to access every object
        // like if we do Stud s1 = new Stud(), then we need it to automatically
        // replace __.rno ka blank space '__' by s1

        // so the keyword to access the ref variable, it's the
        // "this" keyword
        this.rno = 11; // this.rno me 'this' will be replaced by the obj which made
        // s1 obj banaya agar so 'this' == 's1'
        this.name = "kunal kushwaha";
        this.marks = 99.12f;
    }

}
