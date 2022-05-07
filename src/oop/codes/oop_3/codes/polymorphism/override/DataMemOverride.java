package src.oop.oop_3.codes.polymorphism.override;

public class DataMemOverride {
    int n = 90;
}

class Child extends DataMemOverride{
    int n = 10;

    public static void main(String[] args) {
        DataMemOverride obj = new Child();
        // here child class variable does not override the variable in
        // the parent class
        /*

        https://www.javatpoint.com/runtime-polymorphism-in-java

        A method is overridden, not the data members, so runtime polymorphism
         can't be achieved by data members.

        In the example given below, both the classes have a data member
        speedlimit. We are accessing the data member by the reference
        variable of Parent class which refers to the subclass object.
        Since we are accessing the data member which is not overridden,
        hence it will access the data member of the Parent class always.
         */
    }
}