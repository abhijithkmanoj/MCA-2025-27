import java.util.*;

record Attender(String name, String email, int id) {}

public class Register {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Attender> registry = new HashMap<>();

        System.out.println("Type 'exit' as name to stop.");

        while (true) {
            System.out.print("\nEnter Name: ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("exit")) break;

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Registration ID: ");
            int id = Integer.parseInt(sc.nextLine());

            // Check if ID is already taken
            if (registry.containsKey(id)) {
                System.out.println("Error: ID " + id + " is already registered to " + registry.get(id).name());
            } else {
                registry.put(id, new Attender(name, email, id));
                System.out.println("Attender added successfully!");
            }
        }

        System.out.println("\nFinal List of Attenders:");
        registry.values().forEach(System.out::println);
    }
}