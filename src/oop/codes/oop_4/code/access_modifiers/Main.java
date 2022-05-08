package src.oop.oop_4.code.access_modifiers;

public class Main {

    // protected is used in inheritance stuff
    protected int n; // protected cannot be used when object is made
    // in different package which are not subclass ie in different package if
    // object is of subclass (both ref and obj type) then only
    // can use protected but if in that subclass or if its not subclass
    // and we make obj of ref type parent or both ref and obj type parent
    // then we cannot use protected

    // if no modifier is applied then same as above just it can't be used anywhere
    // in the different package be it subclass or parent
}
