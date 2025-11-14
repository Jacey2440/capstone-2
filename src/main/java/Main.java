import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings({"TextBlockMigration", "UnusedAssignment", "DuplicateBranchesInSwitch"})
public class Main {
    public static void main(String[] args) throws IOException {

        Random random = new Random();

        int orderNumberGenerated = random.nextInt(100000);
        String orderNumber = Integer.toString(orderNumberGenerated);


        while (true) {
            System.out.println("\n" + "====Welcome to the Deli====" +
                    "\n" + "1)Order" +
                    "\n" + "0)Exit" +
                    "\n" + "Please choose an option:");


            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    orderScreen(scanner, orderNumber);
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

    private static void orderScreen(Scanner scanner, String orderNumber) throws IOException {
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
                    System.out.println("Still working on it...");
                    break;
                case "2":
                    addDrink(scanner, orderNumber);
                    break;
                case "3":
                    addChips(scanner, orderNumber);
                    break;
                case "4":
                    System.out.println("Still working on it...");
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

    // This prompts the user
    private static void addDrink(Scanner scanner, String orderNumber) throws IOException {
        Receipt receipt = new Receipt(orderNumber);
        boolean correctSize = false;
        Drink drink = null;
        String selectedDrinkSize = "";
        while (!correctSize) {
            System.out.println("What size would you like?"
                    + "\nSmall"
                    + "\nMedium"
                    + "\nLarge"
                    + "\nNo drink");
            selectedDrinkSize = scanner.nextLine().trim().toLowerCase();

            switch (selectedDrinkSize) {
                case "small":
                    drink = new Drink("Small", 2.00);
                    correctSize = true;
                    receipt.writeLine(drink.getDescription());
                    System.out.println("Added a " + selectedDrinkSize + " drink to your total");

                    break;
                case "medium":
                    drink = new Drink("Medium", 2.50);
                    correctSize = true;
                    receipt.writeLine(drink.getDescription());
                    System.out.println("Added a " + selectedDrinkSize + " drink to your total");

                    break;
                case "large":
                    drink = new Drink("Large", 3.00);
                    correctSize = true;
                    receipt.writeLine(drink.getDescription());
                    System.out.println("Added a " + selectedDrinkSize + " drink to your total");

                    break;
                case "no":
                    System.out.println("No drink...going back");
                    correctSize = true;
                    break;
                default:
                    System.out.println("Invalid input...try again");
                    break;
            }
        }
    }

    // This just prompts the user if they want chips
    private static void addChips(Scanner scanner, String orderNumber) throws IOException {
        Receipt receipt = new Receipt(orderNumber);
        boolean wantsChips = false;
        String chips = "";
        Chips chip = null;

        while (!wantsChips) {
            System.out.println("Would you like to add Chips" +
                    "\n Yes or no: ");
            chips = scanner.nextLine().trim().toLowerCase();

            switch (chips) {
                case "yes":
                    wantsChips = true;
                    chip = new Chips("", 1.50);
                    System.out.println("Added chips to the total");
                    receipt.writeLine(chip.getDescription());
                    break;
                case "no":
                    System.out.println("No chips...going back");
                    wantsChips = true;
                    break;

                default:
                    System.out.println("Invalid option try again...");

            }

        }
    }


}