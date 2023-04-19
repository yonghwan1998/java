package xyz.itwill.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// 키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)을 계산하여 출력하는 프로그램 작성
// ex) 생년월일 입력[ex. 2000-01-01] >> 2023-04-18
//    [결과]태어난지 <1일>이 지났습니다. 
// => 형식에 맞지 않는 생년월일을 입력한 경우 에러 메세지 출력 후 프로그램 종료
public class DayCalculateApp {

	public static int returnDate(String year, String month, String date) {

		int temp = 0;
		int leapYearCount = 0;

		Integer y = Integer.parseInt(year);

		switch (Integer.parseInt(month)) {
		case 1:
			temp = 31;
			if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
				leapYearCount -= 1;
			}
			break;
		case 2:
			temp = 59;
			break;
		case 3:
			temp = 90;
			break;
		case 4:
			temp = 120;
			break;
		case 5:
			temp = 151;
			break;
		case 6:
			temp = 181;
			break;
		case 7:
			temp = 212;
			break;
		case 8:
			temp = 243;
			break;
		case 9:
			temp = 273;
			break;
		case 10:
			temp = 304;
			break;
		case 11:
			temp = 334;
			break;
		default:
			temp = 365;
			break;
		}

		for (int i = 1; i <= y; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
				leapYearCount += 1;
			}
		}

		return (Integer.parseInt(year) * 365) + temp + Integer.parseInt(date) + leapYearCount;
	}

	public static void main(String[] args) {

		System.out.println("생년원일 입력 [ex. 2000-01-01]");
		System.out.print(" >> ");

		try {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine().replace("-", "");

			if (input.length() != 8) {
				System.out.println("[error] Incorrect formular.");
				System.exit(0);
			}
			scanner.close();

			String inputYear = input.substring(0, 4);
			String inputMonth = input.substring(4, 6);
			String inputDate = input.substring(6);

			int inputDateSum = returnDate(inputYear, inputMonth, inputDate);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

			String date = simpleDateFormat.format(new Date());
			String currentYear = date.substring(0, 4);
			String currentMonth = date.substring(4, 6);
			String currentDate = date.substring(6);
			int currentDateSum = returnDate(currentYear, currentMonth, currentDate);

			if (inputDateSum > currentDateSum) {
				System.out.println("[error] Incorrect formular.");
				System.exit(0);
			}

			System.out.println("[결과]태어난지 <" + (currentDateSum - inputDateSum + 1) + "일>이 지났습니다. ");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("[error] Incorrect formular.");
		} catch (NumberFormatException e) {
			System.out.println("[error] Incorrect formular.");
		}

	}
}