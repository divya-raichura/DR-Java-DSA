package src.oop.oop_3.revise.revise_2.inheritance;

public class BoxWeight extends Box {
    double weight;

    public BoxWeight(double weight) { // for this to run, there should be an empty constructor
        // in Box so that it initializes those values by default, obviously it needs
        // to have empty constructor otherwise if l,b,h is called then what? need to initialize them
        // hence need an empty constructor there or we can use super and use an argument
        // constructor in the Box as per our choice

        // if we don't have super(args as per our choice) it will call super of empty cons
        // by default, we don't need to put super() in such case
        this.weight = weight;
    }
}
