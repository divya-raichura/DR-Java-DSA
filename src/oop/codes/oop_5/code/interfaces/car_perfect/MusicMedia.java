package src.oop.codes.oop_5.code.interfaces.car_perfect;

public class MusicMedia implements Media{
    @Override
    public void starts() {
        System.out.println("Music starts");
    }

    @Override
    public void stops() {
        System.out.println("Music stops");
    }
}
