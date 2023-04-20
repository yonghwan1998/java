package xyz.itwill.util;

import java.util.Calendar;
import java.util.Scanner;

// 키보드로 [년]과 [월]을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램 작성
public class WantCalendarApp {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("[년]을 입력해주세요. (ex. 2012)");
		int inputYear = scanner.nextInt();

		System.out.println("[월]을 입력해주세요. (ex. 12)");
		int inputMonth = scanner.nextInt();

		scanner.close();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, inputYear);
		calendar.set(Calendar.MONTH, inputMonth - 1);
		calendar.set(Calendar.DATE, 1);
		System.out.println("                         " + calendar.get(Calendar.YEAR) + "년 "
				+ (calendar.get(Calendar.MONTH) + 1) + "월");
		System.out.println("==============================");
		System.out.println("\t 일\t 월\t 화\t 수\t 목\t 금\t 토");
		System.out.println("==============================");

		int week = calendar.get(Calendar.DAY_OF_WEEK);
		for (int i = 1; i < week; i++) {
			System.out.print("	");
		}
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) {
			if (i <= 9) {
				System.out.print("\t " + i);
			} else {
				System.out.print("\t" + i);
			}

			week++;

			if (week % 7 == 1) {
				System.out.println();
			}

		}
		System.out.println();
		System.out.println("==============================");
	}
}