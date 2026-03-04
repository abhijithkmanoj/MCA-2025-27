import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayOps {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Name");
            System.out.println("2. Remove Name");
            System.out.println("3. Search Name");
            System.out.println("4. Sort Names");
            System.out.println("5. Display Names");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter name to add: ");
                    String nameToAdd = sc.nextLine();
                    names.add(nameToAdd);
                    System.out.println("Name added successfully.");
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String nameToRemove = sc.nextLine();
                    if (names.remove(nameToRemove)) {
                        System.out.println("Name removed successfully.");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = sc.nextLine();
                    if (names.contains(nameToSearch)) {
                        System.out.println("Name found in the list.");
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;

                case 4:
                    Collections.sort(names);
                    System.out.println("Names sorted successfully.");
                    break;

                case 5:
                    if (names.isEmpty()) {
                        System.out.println("The list is empty.");
                    } else {
                        System.out.println("List of Names:");
                        for (String n : names) {
                            System.out.println(n);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}