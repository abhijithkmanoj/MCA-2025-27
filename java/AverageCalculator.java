import java.util.Scanner;

// Define the custom exception
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of integers (n): ");
        int n = sc.nextInt();

        double sum = 0;
        int count = 0;

        System.out.println("Enter " + n + " positive integers:");

        while (count < n) {
            try {
                System.out.print("Enter number " + (count + 1) + ": ");
                int num = sc.nextInt();

                if (num < 0) {
                    // Trigger the custom exception
                    throw new NegativeNumberException("Negative input detected: " + num);
                }

                sum += num;
                count++;

            } catch (NegativeNumberException e) {
                // Catch the specific exception and prompt the user again
                System.out.println("Error: " + e.getMessage() + ". Please enter a positive integer.");
            }
        }

        double average = sum / n;
        System.out.println("\n--- Results ---");
        System.out.println("Total Sum: " + sum);
        System.out.printf("Average: %.2f\n", average);

        sc.close();
    }
}