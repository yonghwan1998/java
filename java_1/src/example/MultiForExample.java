package example;

import java.util.Iterator;

public class MultiForExample {
	public static void main(String[] args) {
		String star = "★";
		String emptyStar = "☆";

		// ★★★★★
		// ★★★★
		// ★★★
		// ★★
		// ★

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}

		System.out.println("===============================================================");

		// ★★★★★
		// ☆★★★★
		// ☆☆★★★
		// ☆☆☆★★
		// ☆☆☆☆★

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < i; j++) {
				System.out.print(emptyStar);
			}
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}

		System.out.println("===============================================================");

		// ★
		// ★★★
		// ★★★★★
		// ★★★★★★★
		// ★★★★★★★★★

		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < (2 * i - 1); j++) {
				System.out.print(star);
			}
			System.out.println();
		}

		System.out.println("===============================================================");

		// ★☆☆☆★
		// ☆★☆★☆
		// ☆☆★☆☆
		// ☆★☆★☆
		// ★☆☆☆★

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int temp = i - j;
				if (temp == -4 || temp == -2 || temp == 0 || temp == 2 || temp == 4) {
					System.out.print(star);
				} else {
					System.out.print(emptyStar);
				}
			}
			System.out.println();
		}
		System.out.println("===============================================================");
	}
}
