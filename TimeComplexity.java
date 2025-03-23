import java.util.Scanner;

public class TimeComplexity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input values for a, b, and d
        System.out.print("Enter the value of a (subproblems per recursion): ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b (factor of subproblem size reduction): ");
        int b = scanner.nextInt();
        System.out.print("Enter the value of d (polynomial exponent of n): ");
        double d = scanner.nextDouble();

        scanner.close();

        // Calculate log_b(a)
        double logBA = Math.log(a) / Math.log(b);

        System.out.printf("Comparing log_b(a) = %.4f with d = %.4f%n", logBA, d);

        // Determine complexity based on Master Theorem cases
        if (logBA > d) {
            System.out.println("Case 1: T(n) = O(n^" + logBA + ")");
        } else if (logBA == d) {
            System.out.println("Case 2: T(n) = O(n^" + d + " log n)");
        } else {
            System.out.println("Case 3: T(n) = O(n^" + d + ")");
        }
    }
}
