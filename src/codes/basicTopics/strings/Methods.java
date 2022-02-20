package lectures.strings;

import java.util.Arrays;
import java.util.Locale;

public class Methods {
    public static void main(String[] args) {
        String name = "kunal kushwaha";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toUpperCase());
        System.out.println(name);  // og name doesn't change, so upar sab ke liye naye obj bane thee
        // wohi, strings can't be modified ki wajah se og og hi hai baki ke liye naye bane obj


    }
}
