package src.oop.codes.oop_6.clone;

public class Students implements Cloneable {
    String name;
    int age;
    int[] arr;

//    @Override     // this creates shallow copy -> copy primitives
    // but obj ke case me it points to same arr, so to make new element in
    // objects we need to make deep copy, that is, a completely new arr
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override     // this creates deep copy -> obj ke andar ke elements bhi alag
    protected Object clone() throws CloneNotSupportedException {
        Students twin  = (Students) super.clone(); // as, super.clone gives an object type
        // hence we typecast here
        twin.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
        this.arr = new int[]{1, 3, 35, 6};
    }
}
