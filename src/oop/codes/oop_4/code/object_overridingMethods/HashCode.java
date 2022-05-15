package src.oop.codes.oop_4.code.object_overridingMethods;

public class HashCode {
    int n;

    public HashCode(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        HashCode a = new HashCode(24);
        HashCode b = new HashCode(18);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
