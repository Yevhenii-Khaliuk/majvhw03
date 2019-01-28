package calculator;

public class RomanToArabicConverter {
    private enum RomanNumbers {
        M(1000), CM(900), D(500), CD(400), C(100), XC(90),
        L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

        private int value;

        RomanNumbers(int value) {
            this.value = value;
        }

        private int getValue() {
            return value;
        }
    }

    public static int convert(String roman) {
        roman = roman.toUpperCase();
        for (RomanNumbers romanNumber : RomanNumbers.values()) {
            if (roman.startsWith(romanNumber.name())) {
                return romanNumber.getValue() + convert(roman.replaceFirst(romanNumber.name(), ""));
            }
        }
        return 0;
    }
}
