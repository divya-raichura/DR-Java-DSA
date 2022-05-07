package src.oop.oop_3.codes.polymorphism.understandPoly_;

public class ObjectPrint_toString { // extends Object class as every class does and Object
    // class has toString method which is used by default if we don't make by our own

    int num;

    public ObjectPrint_toString(int num) {
        this.num = num;
    }

    @Override // at runtime it will determine that now, this toString method should be run
    public String toString() {
        return "ObjectPrint_toString{" +
                "num = " + num +
                '}';
    }

    public static void main(String[] args) {
        ObjectPrint_toString s = new ObjectPrint_toString(52);
        System.out.println(s); // println uses valueOf which calls obj.toString method
        // we haven't told that when we print object(s), it should print 'num'
        // so java will check that is obj that we passed have toString method, no it doesn't
        // hence it will use the default one, and as each class is inherited from the obj
        // class so it will use obj classes' to string method which is :
        // return getClass().getName() + "@" + Integer.toHexString(hashCode());
        // if "we" provide the toString method then it is called as it overrides the default one



        // In the Shape example:
                     /*

         if this circle class does not have area method in it,
         then the area method in Shape(parent class) will be called by default
         but if circle has area method, then that area method will be called
         similar to toString method, when we do sout(circle),
         toString method is called, now if our object does not have it, parent class toString will be called
         and it will print the default value but if we make our own toString and tell it what to print
         when we do sout(object_ref_var), it will override and call our toString

                     */
    }
}
