package src.oop.codes.oop_6.compares.comparable;

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

        System.out.println(player1);

        // if we compare without implementing comparable, gives error
//        if (player2.compareTo(player3) > 0) {  // we can't do player1.compareTo(player2) as the method returns int not bool
//            System.out.println("player2");
//        } else if (player1.compareTo(player2) == 0) {
//            System.out.println("woh");
//        } else {
//            System.out.println("player3");
//        }

        // sorting
        // below prints what we ask it to print in the toString method, but whatever it prints,
        // it is sorted according to the ranking
        // matlab, sortings ranking ke hisab se hai, but in toString we can tell
        // it that name print karo ya age ya ranking itself

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam);
        System.out.println("After Sorting : " + footballTeam);

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

//        Arrays.sort(arr, new Comparator<Player>() {
//            @Override
//            public int compare(Player o1, Player o2) {
//                return Integer.compare(o1.ranking, o2.ranking);
//            }
//        });
//        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr, (Player o1, Player o2) -> Integer.compare(o1.age, o2.age));
        // if we don't provide this lamba function, then it will use
        // the compareTo in the Player class
//        System.out.println(Arrays.toString(arr));
    }

}
