package src.codes.recursion.revise.rev_2;

public class RemoveA {
    public static void main(String[] args) {
//        System.out.println(remove("", "Divya Raichura"));
        System.out.println(removeA("Divya Raichura"));
    }

    static void remove(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p);
            return;
        }

        char ch = up.charAt(0);
        if (ch == 'a') {
            remove(p, up.substring(1));
        } else {
            remove(p + ch, up.substring(1)); // ch + p likha toh reverse print karta
        }

    }

    static String removeA(String name) {
        if (name.isEmpty()) {
            return "";
        }
        char ch = name.charAt(0);
        if (ch == 'a') {
            return removeA(name.substring(1));
        }
        // reverses
//        return removeA(name.substring(1)) + ch;
        // does not reverse
        return ch + removeA(name.substring(1));
    }

}
