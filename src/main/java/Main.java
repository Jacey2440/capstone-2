import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n" + "====Welcome to the Deli====" +
                    "\n" + "1)Order" + "\n" + "0)Exit" + "\n" + "Please choose an option:");


            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
//                order();
                    System.out.println("You decided to order...");
                    break;
                case "0":
                    System.out.println("Exiting now...");
                    return;

                default:
                    System.out.println("\n" + "This was an invalid option...Try again");
                    break;
            }

        }
    }

    private static void orderScreen(){

    }
}
