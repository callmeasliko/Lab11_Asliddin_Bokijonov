import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<String> list = new ArrayList<>();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String menuOption;

        do {
            displayMenu();
            menuOption = SafeInput.getRegExString(in, "Choose an option [A, D, I, P, Q]", "[AaDdIiPpQq]");

            switch (menuOption.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit")) {
                        System.out.println("Exiting program.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }

        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem() {
        String newItem = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        list.add(newItem);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        int itemNumber = SafeInput.getRangedInt(in, "Enter the item number to delete", 1, list.size());
        String removedItem = list.remove(itemNumber - 1);
        System.out.println("Deleted: " + removedItem);
    }

    private static void insertItem() {
        int position;

        if (list.isEmpty()) {
            System.out.println("The list is empty. Inserting at position 1.");
            position = 1;
        } else {
            position = SafeInput.getRangedInt(in, "Enter the position to insert the item", 1, list.size() + 1);
        }

        String newItem = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        list.add(position - 1, newItem);
        System.out.println("Item inserted at position " + position + ".");
    }

    private static void printList() {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}
