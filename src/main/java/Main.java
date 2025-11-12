import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n" + "====Welcome to the Deli====" +
                    "\n" + "1)Order" +
                    "\n" + "0)Exit" +
                    "\n" + "Please choose an option:");


            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    orderScreen(scanner);
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

    private static void orderScreen(Scanner scanner) {
        boolean viewing = true;
        while (viewing) {

            System.out.println("====Order Menu====");
            System.out.println("1)Add Sandwich" +
                    "\n" + "2)Add Drink" +
                    "\n" + "3)Add Chips" +
                    "\n" + "4)checkout" +
                    "\n" + "0)Cancel Order");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
//                Add Sandwich
                    break;
                case "2":
//                add drink
                    break;
                case "3":
//                add chips
                    break;
                case "4":
//                checkout
                    break;
                case "0":
                    viewing = false;
                    break;
                default:
                    System.out.println("Invalid option...Try again");
                    break;


            }

        }


    }
}
