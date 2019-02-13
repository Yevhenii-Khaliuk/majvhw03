package com.khaliuk.mergesort;

import java.util.Random;

public class MergeSortDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[50];
        System.out.println("Starting array:");
        for (int i = 0; i < 50; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        MergeSort.sort(array);
        System.out.println();
        System.out.println("Sorted array:");
        for (int i = 0; i < 50; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
