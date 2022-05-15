package src.oop.codes.oop_6.compares.comparator;

import src.oop.codes.oop_6.compares.comparable.Player;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);

        List<Player> footballTeam = new ArrayList<>();
        Player[] arr = {player1, player2, player3};

        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);


    }

}
