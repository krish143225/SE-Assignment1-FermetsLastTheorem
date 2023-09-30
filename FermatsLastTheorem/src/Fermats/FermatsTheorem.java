package Fermats;
import java.util.Scanner;

public class FermatsTheorem {

    // Calculate the relative miss
    public static double calculateMiss(int x, int y, int z, int n) {
        double result = Math.pow(x, n) + Math.pow(y, n);
        double zToN = Math.pow(z, n);

        double miss = Math.abs(result - zToN);
        double relativeMiss = miss / result;
        return relativeMiss;
    }

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("\nFermat's Last Theorem \n");

        // Get input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n should be greater than 2 and less than 12: ");
        int n = scanner.nextInt();
        System.out.print("\nEnter the value of k should be greater than 10: ");
        int k = scanner.nextInt();
        scanner.close();

        double minimumRelativeMissValues = Double.POSITIVE_INFINITY;
        int minX = 0, minY = 0;

        // Check if input values are valid or not
        if (n > 2 && n < 12 && k > 10) {
            for (int x = 10; x <= k; x++) {
                for (int y = 10; y <= k; y++) {
                    for (int z = 1; z <= k; z++) {
                        if (x != y) {
                            double relativeMiss = calculateMiss(x, y, z, n);

                            if (relativeMiss < minimumRelativeMissValues) {
                                minimumRelativeMissValues = relativeMiss;
                                minX = x;
                                minY = y;
                            }
                        }
                    }
                }
            }

            // Print result
            System.out.println("\nRelative miss:");
            System.out.println("x = " + minX + ", y = " + minY);
            System.out.printf("Relative diff = %.7f%n", minimumRelativeMissValues);
        } else {
            // Print invalid input
            System.out.println("Invalid input. Please make sure n value should be greater than 2 and less than 12, and k greater than 10");
        }
    }
}
