package src.oop.codes.oop_2.staticEg;

public class Main {
    public static void main(String[] args) {
        // Human is in same folder as Main so, we do not have to import it
        // ie, if the files are in same folder, we do not need to put import statement
//        Human divya = new Human(19, "DivyaR", 1_00_00_000, false);
//        Human kunal = new Human(22, "Kunal Kushwaha", 40_00_000, false);
//        System.out.println(divya.population);
//        System.out.println(kunal.population);
        System.out.println(Human.population);
        System.out.println(Human.population);
        // variable is static then we can use it even without creating obj
        // cause static means they are independent of any object, written below in detail
    }

    // Human is a class and it will have another property called population
    // which means how many humans exist and that is going to be same for
    // all the humans, eg population of planet is going to be same, whether
    // the person is divya or kunal, it is common to all humans(objects)
    // ie for all the objects of human class, this property is common, it is object independent and not related to any object
    // such properties that are not directly related to object are known as static

}
