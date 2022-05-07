package src.codes.basicTopics.functions;

// explanation in my notes :-

public class Why {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6};
//        arr = {144, 67, 8, 85};


        // this and uske niche wala does same, but this is more better
        // explained in note but again :-
        // cause  new int[]{144, 67, 8, 85} this keyword means create new object
        // of type array in heap,  arr = new int[]{144, 67, 8, 85};  this as whole
        // means make new array object in heap and arr ka reference udar change kardo
        // so now arr points to new array {144, 67, 8, 85} and not {3, 4, 5, 6}
        arr = new int[]{144, 67, 8, 85};

//        int[] num = {144, 67, 8, 85};
//        arr = num;


        int a = 3;
        a = 22;


    }
}
