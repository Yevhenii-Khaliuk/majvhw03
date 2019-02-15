package com.khaliuk.mergesort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MergeSortTest {
    @Test
    public void testSortProduceSortedInNaturalOrderArray() {
        int[] expectedResult = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actualResult = new int[] {8, 3, 9, 1, 2, 10, 4, 5, 7, 6};
        MergeSort.sort(actualResult);
        assertArrayEquals(expectedResult, actualResult);
    }

}