package src.oop.codes.oop_6.compares.comparator;

import java.util.Comparator;

public class Player implements Comparator<Player> {
    int ranking;

    String name;

    int age;

    @Override
    public String toString() {
        return this.name + ""; //
    }

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }


    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o1.ranking, o2.ranking);
    }
}
