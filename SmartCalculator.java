import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class SmartCalculator {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            showMenu();
            int choice = getIntInput();

            switch (choice) {
                case 1 -> basicOperation();
                case 2 -> scientificOperation();
                case 3 -> temperatureConversion();
                case 4 -> {
                    System.out.println("Exiting Calculator...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n==== SMART CALCULATOR ====");
        System.out.println("1. Basic Operations");
        System.out.println("2. Scientific Operations");
        System.out.println("3. Temperature Conversion");
        System.out.println("4. Exit");
        System.out.print("Choose option: ");
    }

    private static void basicOperation() {
        try {
            System.out.print("Enter first number: ");
            BigDecimal num1 = input.nextBigDecimal();

            System.out.print("Enter second number: ");
            BigDecimal num2 = input.nextBigDecimal();

            System.out.print("Enter operator (+ - * /): ");
            char op = input.next().charAt(0);

            BigDecimal result = switch (op) {
                case '+' -> num1.add(num2);
                case '-' -> num1.subtract(num2);
                case '*' -> num1.multiply(num2);
                case '/' -> num1.divide(num2, 4, RoundingMode.HALF_UP);
                default -> throw new IllegalArgumentException("Invalid operator");
            };

            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error occurred. Please enter valid numbers.");
            input.nextLine();
        }
    }

    private static void scientificOperation() {
        System.out.println("1. Square Root");
        System.out.println("2. Power");
        int option = getIntInput();

        if (option == 1) {
            System.out.print("Enter number: ");
            double value = input.nextDouble();
            System.out.println("Square Root: " + Math.sqrt(value));
        } else if (option == 2) {
            System.out.print("Enter base: ");
            double base = input.nextDouble();
            System.out.print("Enter exponent: ");
            double exp = input.nextDouble();
            System.out.println("Result: " + Math.pow(base, exp));
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void temperatureConversion() {
        System.out.print("Enter temperature in Celsius: ");
        double c = input.nextDouble();
        double f = (c * 9 / 5) + 32;
        System.out.println("Fahrenheit: " + f);
    }

    private static int getIntInput() {
        try {
            return input.nextInt();
        } catch (Exception e) {
            input.nextLine();
            return -1;
        }
    }
}

