package src.oop.oop_3.codes.inheritance.extends_super;

// child class
// it wants every property that is in parent class "Box"
// for that we use extends keyword

public class BoxWeight extends Box {
    double weight;

    public BoxWeight() {
        this.weight = -1;
    }

    // in order to set l,b,h it has to get the values from parent class "Box" cause they exist there
    // and there these values are initialized in constructor having l,b,h arguments
    public BoxWeight(double l, double b, double h, double weight) {
        super(l, b, h);// so, this keyword simply means call the parent class constructor having l,b,h as arguments
        // used to initialize present in parent class, it calls parent class constructor
        this.weight = weight;
    }


    public BoxWeight(double weight) { // for this to run, there should be an empty constructor
        // in Box so that it initializes those values by default, obviously it needs
        // to have empty constructor otherwise if l,b,h is called then what? need to initialize them
        // hence need an empty constructor there, or we can use super and use an argument
        // constructor in the Box as per our choice

        // if we don't have super(args as per our choice) it will call super of empty cons
        // by default, we don't need to put super() in such case
        this.weight = weight;
    }

    public BoxWeight(double l, double b, double h) {
        super(l, b, h);// so, this keyword simply means call the parent class constructor having l,b,h as arguments
        // used to initialize values present in parent class, it calls parent class constructor

        // NOTE: though child class can use properties of parent class, it can't use
        // those properties which are private
        // suppose private double l was there
        // though it is private and u can't use it outside 'Box' file, why are we able to initialize l here
        // in super? because this BoxWeight class is not initializing it, the 'Box' class is initializing it
        // control+click the super and u will see that Box class constructor is being called
    }

    BoxWeight(BoxWeight old) {
        // if we don't declare super, it will go to empty constructor of box and assign l,b,h = -1
        super(old); // exactly same as Box s = new BoxWeight();
        // if super is not there, it will go to that empty constructor and assign -1 to all l,b,h
        this.weight = old.weight;
    }
}
