package com.khaliuk.mergesort;

public class MergeSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            sort(array, low, middle);
            sort(array, middle + 1, high);
            merge(array,low, middle, high);
        }
    }

    private  static void merge(int[] array, int low, int middle, int high) {
        int leftPointer = low;
        int rightPointer = middle + 1;

        if (array[middle] <= array[rightPointer]) {
            return;
        }
        while (leftPointer <= middle && rightPointer <= high) {
            if (array[leftPointer] <= array[rightPointer]) {
                leftPointer++;
            } else {
                int temp = array[rightPointer];
                int index = rightPointer;
                while (index != leftPointer) {
                    array[index] = array[index - 1];
                    index--;
                }
                array[leftPointer] = temp;
                leftPointer++;
                middle++;
                rightPointer++;
            }
        }
    }
}
