package src.oop.oop_3.codes.finalKeyword;
// https://www.javatpoint.com/final-keyword
public class finalKeyWord {
    final int a; // can't declare final variable here but can declare

    // it inside main
    // agar aise declare karna hai toh constructor me initialize karo
    finalKeyWord() {
        a = 3;
        System.out.println("pancho");
    }

    // static final keyword
    // this also can't be alone declared, it needs to be initialized
    // and for this constructor doesn't work
    // to initialize it we need static block
    static final int b;
    static {
        b = 2;
    }

//    finalKeyWord(String name) {
////        Q) Can we declare a constructor final?
////        No, because constructor is never inherited.
//    }

    public static void main(String[] args) {
        final int a;
        int a1;
        a1 = 21;
//        a = 3;
        for (int i = 0; i < 3; i++) {
            if (i == 2){
                a1 = 4;
            }
        }
        a = a1;
        int b =2 ;
        finalKeyWord ob = new finalKeyWord();

    }
}