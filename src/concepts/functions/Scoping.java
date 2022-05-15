package lectures.functions;

public class Scoping {
    static int x = 1;
    public static void main(String[] args) {
        int a = 69;
        // int c = 66; // can't do this wow matlab, agar scope ke niche kiya toh chalega par idar kiya
        // toh scope ke andar nahi inita karskte par scope pe inita karke scope ke niche inita kiya
        // toh chalega wah wah inception
        {
            // int a = 9; // can't do like this
             a = 9;
             int c = 2; //
            System.out.println(c);
        }
//        c = 4; // can't do this wow
        int c = 4;
        System.out.println(c);
    }
}


