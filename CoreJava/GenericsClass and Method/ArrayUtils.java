package com.wipro.assign;

import java.util.Arrays;

public class ArrayUtils {

	public static <T> void swap(T[] array, int index1, int index2) {
		if (index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Original Integer array: " + Arrays.toString(intArray));
        swap(intArray, 1, 3);
        System.out.println("Swapped Integer array: " + Arrays.toString(intArray));

        // Example usage with String array
        String[] stringArray = {"a", "b", "c", "d"};
        System.out.println("Original String array: " + Arrays.toString(stringArray));
        swap(stringArray, 0, 2);
        System.out.println("Swapped String array: " + Arrays.toString(stringArray));

        // Example usage with Double array
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        System.out.println("Original Double array: " + Arrays.toString(doubleArray));
        swap(doubleArray, 2, 3);
        System.out.println("Swapped Double array: " + Arrays.toString(doubleArray));
	}

}
