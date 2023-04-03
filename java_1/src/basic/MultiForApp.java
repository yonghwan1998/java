package basic;

public class MultiForApp {

	public static void main(String[] args) {

		int count = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("============================");
//		★★★★★★★
//		★★★★★★★
//		★★★★★★★
//		★★★★★★★
//		★★★★★★★

		String star = "★";
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 7; i++) {
				System.out.print(star);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("============================");

//		★★★★★★★★
//		★★★★★★★★
//		★★★★★★★★
//		★★★★★★★★
//		★★★★★★★★
//		★★★★★★★★
//		★★★★★★★★
//		★★★★★★★★
//		★★★★★★★★

		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 8; i++) {
				System.out.print(star);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("============================");

//		2*1=2	3*1=3	4*1=4	5*1=5	6*1=6	7*1=7	8*1=8	9*1=9	
//		2*2=4	3*2=6	4*2=8	5*2=10	6*2=12	7*2=14	8*2=16	9*2=18	
//		2*3=6	3*3=9	4*3=12	5*3=15	6*3=18	7*3=21	8*3=24	9*3=27	
//		2*4=8	3*4=12	4*4=16	5*4=20	6*4=24	7*4=28	8*4=32	9*4=36	
//		2*5=10	3*5=15	4*5=20	5*5=25	6*5=30	7*5=35	8*5=40	9*5=45	
//		2*6=12	3*6=18	4*6=24	5*6=30	6*6=36	7*6=42	8*6=48	9*6=54	
//		2*7=14	3*7=21	4*7=28	5*7=35	6*7=42	7*7=49	8*7=56	9*7=63	
//		2*8=16	3*8=24	4*8=32	5*8=40	6*8=48	7*8=56	8*8=64	9*8=72	
//		2*9=18	3*9=27	4*9=36	5*9=45	6*9=54	7*9=63	8*9=72	9*9=81

		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + "*" + i + "=" + (i * j) + "\t");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("============================");

//		★
//		★★
//		★★★
//		★★★★
//		★★★★★

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("============================");

//		★★★★★
//		★★★★
//		★★★
//		★★
//		★

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (5 - i); j++) {
				System.out.print(star);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("============================");

//		☆☆☆☆★
//		☆☆☆★★
//		☆☆★★★
//		☆★★★★
//		★★★★★

		String emptyStar = "☆";

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (4 - i); j++) {
				System.out.print(emptyStar);
			}
			for (int j = 0; j < (i + 1); j++) {
				System.out.print(star);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("============================");

//		☆☆☆☆★
//		☆☆☆★★
//		☆☆★★★
//		☆★★★★
//		★★★★★

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i + j < 4) {
					System.out.print(emptyStar);
				} else {
					System.out.print(star);
				}
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("============================");
	}

}
