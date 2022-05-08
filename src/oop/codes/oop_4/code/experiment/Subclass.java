package src.oop.oop_4.code.experiment;

import src.oop.oop_4.code.access_modifiers.Main;

public class Subclass extends Main{
    public static void main(String[] args) {
        Main obj = new Main();
//        int x = obj.n; // can't access protected in diff package

        Main b = new Subclass(); // can't access protected in diff package
        // having ref type of parent

        Subclass o = new Subclass();
        int a = o.n; // can access protected in diff package subclass
    }
}


class Subsubclass extends Subclass { // multilevel inheritance
    // this can also use protected of parent // only parent can't use it
    // here subclass is parent of this class subsubclass // so here it can't
    // access subclass
    public static void main(String[] args) {
        Subclass o = new Subclass();
//        int a = o.n;

        Subsubclass obj = new Subsubclass();
        int a = obj.n; // this is the child so it can use protected
    }
}

class Subclass2 extends Main {
    public static void main(String[] args) {
        Subclass2 obj = new Subclass2();
        int a = obj.n; // can access in other subclass as well
    }
}

