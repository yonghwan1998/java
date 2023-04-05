package oop;

import java.util.Arrays;

public class ArraySortApp {

	public static void main(String[] args) {

		int[] array = { 30, 50, 10, 40, 20 };

		System.out.print("정렬 전 >>  "+Arrays.toString(array));
		
		Arrays.sort(array);
		System.out.print(Arrays.toString(array));
	}
}
