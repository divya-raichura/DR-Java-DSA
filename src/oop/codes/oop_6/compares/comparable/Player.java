package src.oop.codes.oop_6.compares.comparable;

public class Player implements Comparable<Player> {
    int ranking;

    String name;

    int age;

    @Override
    public String toString() {
 // decides what should be printed when we try to print object ref var itself
 // that is, Object obj = new Object(); print(obj) // this prints what
        // we tell it to print here this.ranking prints ranking and
        // this.name will print the name
        return this.name + " haha ";
    }

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Player otherPlayer) { // decides on which
        // parameter should the objects be compared
        return Integer.compare(this.ranking, otherPlayer.ranking);
    }
}
