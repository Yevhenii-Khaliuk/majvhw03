package calculator;

import java.util.Scanner;

public class ConverterDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Roman number:");
        String romanNumber = scanner.next();
        System.out.println("Arabic: " + RomanToArabicConverter.convert(romanNumber));
    }
}
