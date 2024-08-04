package CongoRise;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int num1, num2, result = 0, operations;
        System.out.println("------- Calculator ----------");
        System.out.println("1 - Addition \n2 - Subtraction \n3 - Multiplication \n4 - Division");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        operations = sc.nextInt();

        if (operations < 1 || operations > 4) {
            System.out.println("Invalid operator!");
        } else {

            System.out.print("Enter first number: ");
            num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            num2 = sc.nextInt();

            try {
                switch (operations) {
                    case 1:
                        result = num1 + num2;
                        break;
                    case 2:
                        result = num1 - num2;
                        break;
                    case 3:
                        result = num1 * num2;
                        break;
                    case 4:
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator!");
                }
                System.out.println("Result = " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
