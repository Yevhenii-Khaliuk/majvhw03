package calculator;

import java.util.Scanner;

public class ConsoleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the expression to evaluate:");
        String expression = scanner.nextLine();
        System.out.print("Result is: ");
        System.out.println(Calculator.calculate(expression));
    }
}
