package com.khaliuk.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculatorTest {
    @Test
    public void testCalculateReturnsCorrectResultForSimpleArabicExpression() {
        double expectedResult = 100.0;
        double actualResult = Calculator.calculate("100 * (2 + 12 * 2 - 12) / 14");
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void testCalculateReturnsCorrectResultForArabicExpressionWithUnaryMinus() {
        double expectedResult = -100.0;
        double actualResult = Calculator.calculate("100 * (2 + 12) / -14");
        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void testCalculateReturnsCorrectResultForSimpleRomanExpression() {
        double expectedResult = 100.0;
        double actualResult = Calculator.calculate("C * (II + XII) / XIV");
        assertEquals(expectedResult, actualResult, 0.001);
    }
}