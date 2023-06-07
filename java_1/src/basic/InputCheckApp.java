package basic;

import java.util.Scanner;

public class InputCheckApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int score = -1;
		String grade = "";

		while (true) {
			System.out.println("점수 입력 >> ");
			score = scanner.nextInt();
			if (score >= 0 && score <= 100) {
				break;
			} else {
				System.out.println("[에러]점수는 0 ~ 100 범위의 점수값만 입력 가능");
			}
		}
		scanner.close();

		switch (score / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		case 5:
			grade = "E";
			break;
		default:
			grade = "F";
			break;
		}
		System.out.println("점수 : " + score + "는 학점 : " + grade + "입니다.");
	}
}
