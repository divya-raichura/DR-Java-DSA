package src.codes.basicTopics.bitwiseOperators.lec_1;


public class BitFind_Set_Reset {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 2, 1, 3, 6, 4};
//        System.out.println(noDup(arr));
//        System.out.println(bitFind(6, 3));
//        System.out.println(bitFind2(6, 3));
//        System.out.println(set(182,4));
//        System.out.println(reset(182,5));
    }


    // dek 1010 hai and for 3rd bit '1 << (ith - 1)' will be 0100
    // we do 'and', we get 0000 which is '> 0', so we print "not set"
    // if number was 1110 we would have got 0100 after '&' and it is '< 0'  hence "set"
    static void gfg(int num, int ith) {
        if ((num & (1 << (ith - 1))) > 0) {
            System.out.println("set");
        } else {
            System.out.println("not set");
        }
    }

    static String bitFind(int num, int ith) {
//        return ((num & (1 << (ith - 1))) >> (ith-1));
        return Integer.toBinaryString(((num & (1 << (ith - 1))) >> (ith-1)));
//        return Integer.toBinaryString((num) & (1 << (ith - 1))); // dek u get final ans, eg- 000100
        // but then it prints it in decimal which is "4" here and on top of that
        // we need single bit which is "1" or "0" not whole 000100 hence, we do (>> ith -1)
    }

    // doubt - why is this priting 1/0 only, without the use of Integer.toBinaryString();
    static int bitFind2(int num, int ith) {
        return ((num & (1 << (ith - 1))) >> (ith-1));
//        return Integer.toBinaryString((num) & (1 << (ith - 1))); // dek u get final ans, eg- 000100
        // but then it prints it in decimal which is "4" here and on top of that
        // we need single bit which is "1" or "0" not whole 000100 hence, we do (>> ith -1)
    }

    static String set(int num, int ith) {
//        System.out.println(num);
//        System.out.println(Integer.toBinaryString(num));
//        System.out.println((num | (1 << (ith - 1))));
        return Integer.toBinaryString((num | (1 << (ith - 1))));
    // 1) we don't do (>>ith -1) as we want whole binary number, not just one bit of
    // that binary number

    // 2) just (num | (1 << (ith - 1))) gives ans but in decimal, hence
    // to convert and print ans in binary, we use Integer.toBinaryString();
    }

    static String reset(int num, int ith) {
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
        System.out.println((num & ~(1 << (ith - 1))));
        return Integer.toBinaryString((num & ~(1 << (ith - 1))));
    }
}

