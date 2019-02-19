package com.khaliuk.calculator;

import java.util.Stack;

public class Calculator {
    private  static Stack<Character> operators = new Stack<>();
    private static Stack<Double> nums = new Stack<>();

    public static double calculate (String expression) {
        boolean prevIsOperator = true;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') {
                continue;
            }
            if (isArabicNumber(expression.charAt(i)) || isRomanNumber(expression.charAt(i))) {
                i = pushNumber(expression, i);
                prevIsOperator = false;
            } else if (expression.charAt(i) == '(') {
                operators.push(expression.charAt(i));
                prevIsOperator = true;
            } else if (expression.charAt(i) == ')') {
                while (operators.peek() != '(') {
                    nums.push(performOperator(operators.pop(), nums.pop(), nums.pop()));
                }
                operators.pop();
                prevIsOperator = true;
            } else if (isOperator(expression.charAt(i))) {
                if (expression.charAt(i) == '-' && prevIsOperator) {
                    i++;
                    i = pushNumber(expression, i);
                    nums.push(-nums.pop());
                    prevIsOperator = false;
                    continue;
                }
                while (!operators.empty() && hasPrecedence(expression.charAt(i), operators.peek())) {
                    nums.push(performOperator(operators.pop(), nums.pop(), nums.pop()));
                }
                operators.push(expression.charAt(i));
                prevIsOperator = true;
            }
        }
        while (!operators.empty()) {
            nums.push(performOperator(operators.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private  static int pushNumber(String expression, int i) {
        if (isArabicNumber(expression.charAt(i))) {
            return pushArabicNumber(expression, i);
        } else {
            return pushRomanNumber(expression, i);
        }
    }

    private static int pushRomanNumber(String expression, int i) {
        StringBuilder temp = new StringBuilder();
        while (i < expression.length() && isRomanNumber(expression.charAt(i))) {
            temp.append(expression.charAt(i));
            i++;
        }
        nums.push((double) RomanToArabicConverter.convert(temp.toString()));
        i--;
        return i;
    }

    private static int pushArabicNumber(String expression, int i) {
        StringBuilder temp = new StringBuilder();
        while (i < expression.length() && isArabicNumber(expression.charAt(i))) {
            temp.append(expression.charAt(i));
            i++;
        }
        nums.push(Double.parseDouble(temp.toString()));
        i--;
        return i;
    }

    private static boolean isArabicNumber(char num) {
        return num >= '0' && num <= '9';
    }

    private static boolean isRomanNumber(char num) {
        num = Character.toUpperCase(num);
        return num == 'I' || num == 'V' || num == 'X' || num == 'L' || num == 'C' || num == 'D' || num == 'M';
    }

    private static boolean isOperator(char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    private static boolean hasPrecedence(char operator1, char operator2) {
        if (operator2 == '(' || operator2 == ')') {
            return false;
        } else if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
            return false;
        } else {
            return true;
        }
    }

    private static double performOperator(char operator, double rightNum, double leftNum) {
        switch (operator) {
            case '+':
                return leftNum + rightNum;
            case '-':
                return leftNum - rightNum;
            case '*':
                return leftNum * rightNum;
            case '/':
                if (rightNum == 0) {
                    throw new ArithmeticException("Division by zero is not supported!");
                }
                return leftNum / rightNum;
            default:
                return 0;
        }
    }
}
