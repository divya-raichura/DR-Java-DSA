package src.oop.codes.oop_6.generics;

public class Instantiate_typeParameters {


    // how to instantiate then?
    /*

     public class Foo<T> {

    private Class<T> type;
    public Foo(Class<T> type) {
      this.type = type;
    }

    public Class<T> getType() {
      return type;
    }

    public T newInstance() {
      return type.newInstance();
    }
 }
     */

    // resources :-

// https://stackoverflow.com/questions/20795527/why-java-cannot-create-instances-of-type-parameters
// type erasure sec in: https://www.baeldung.com/java-generics
// https://stackoverflow.com/questions/1090458/instantiating-a-generic-class-in-java
// https://stackoverflow.com/questions/2434041/instantiating-generics-type-in-java
// https://stackoverflow.com/questions/75175/create-instance-of-generic-type-in-java


//  This is impossible because of the following 2 reasons. (from below site)

// https://softwareengineering.stackexchange.com/questions/320292/why-generic-type-can-not-instantiated
//  There is no guarantee that T has a no-args constructor (and for that matter isn't an interface or abstract class)
//  Due to type erasure (required for backwards compatibility) the Type of T is
//  known at compile time but not at run time, so what to construct wouldn't be known.
//  An answer may be to take a T factory in the constructor. Then Gen can request new Ts to its heart content.
}
