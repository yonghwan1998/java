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

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				int tempP = i + j;
				int tempM = i - j;
				if (tempM == 0 || tempP == 6) {
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
