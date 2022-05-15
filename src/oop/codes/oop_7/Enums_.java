package src.oop.codes.oop_7;

import java.util.Arrays;

public class Enums_ {
    enum Week { // when we have fixed group of objects we use enums
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

        // all these are enum constants
        // they are by default public, static, final
        // cannot create child enums as it is final
        // type of all these constants is Week, name of enum
        Week() {
            // this is not public or protected. Only private or default
            // cause we want enum to have only constant number of days, thats what
            // the purpose and objective of enums is
            // hence to avoid initialization of more objects we have this
            System.out.println("constructor for : " + this);
        }

        // internally: public static final Week Monday = new Week();
    }

    public static void main(String[] args) {
        Week wik = Week.Saturday;
        System.out.println(wik);
        System.out.println(Arrays.toString(Week.values()));
        for (Week day : Week.values()) {
            System.out.println(day);
        }

    }

}
