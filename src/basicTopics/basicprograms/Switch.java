package src.codes.basicTopics.basicprograms;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int day = in.nextInt();

//        switch (day) {
//            case 1:
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("weekdays");
//                break;
//            case 6:
//            case 7:
//                System.out.println("weekends");
//                break;
//        }

//        switch (day) {
//            case 1, 2, 3, 4, 5 -> System.out.println("weekdays");
//            case 6, 7 -> System.out.println("weekends");
//        }

//        int EmpId = in.nextInt();
//        String department = in.next();
//
//        switch (EmpId) {
//            case 1:
//                System.out.println("Kunal Kushwaha");
//                break;
//            case 2:
//                System.out.println("Divya Raichura");
//                break;
//            case 3:
//                System.out.println("Employ number 3");
//                switch (department) {
//                    case "IT":
//                        System.out.println("IT Department");
//                        break;
//                    case "Management":
//                        System.out.println("Management Department");
//                        break;
//                    default:
//                        System.out.println("No department entered");
//                }
//                break;
//            default:
//                System.out.println("Enter correct EmpId");
//        }

        int EmpId = in.nextInt();
        String department = in.next();

        switch (EmpId) {
            case 1 -> System.out.println("Kunal Kushwaha");
            case 2 -> System.out.println("Divya Raichura");
            case 3 -> {
                System.out.println("Employ number 3");
                switch (department) {
                    case "IT" -> System.out.println("IT Department");
                    case "Management" -> System.out.println("Management Department");
                    default -> System.out.println("No department entered");
                }
            }
            default -> System.out.println("Enter correct EmpId");
        }
    }
}
