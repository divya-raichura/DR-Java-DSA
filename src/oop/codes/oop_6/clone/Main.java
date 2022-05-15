package src.oop.codes.oop_6.clone;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Students kunal = new Students("Kunal", 29);
        Students kushwaha = (Students) kunal.clone();

    }
}
