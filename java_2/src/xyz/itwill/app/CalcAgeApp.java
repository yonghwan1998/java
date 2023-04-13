package xyz.itwill.app;

import java.util.Date;
import java.util.Scanner;

public class CalcAgeApp {
	public static void main(String[] args) {

		Date now = new Date();
		@SuppressWarnings("deprecation")
		int currentYear = now.getYear() + 1900;

		Scanner scanner = new Scanner(System.in);

		System.out.print("이름 입력 >> ");
		String name = scanner.next();

		System.out.print("태어난 년도 입력 >> ");
		int birthYear = scanner.nextInt();
		int age = currentYear - birthYear + 1;

		System.out.println("[결과] " + name + "님의 나이는 " + age + "살입니다.");

		scanner.close();
	}
}
