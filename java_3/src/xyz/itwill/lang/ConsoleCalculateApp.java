package xyz.itwill.lang;

import java.util.Scanner;

// 키보드로 사칙 연산식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
// ex) 연산식 입력 >> 20 + 10
//    [결과]30
// => 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)만 허용
// => 형식에 맞지 않는 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 종료
// => 입력 연산식에 공백 입력이 가능하도록 처리
public class ConsoleCalculateApp {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String inputString;

		System.out.println("연산식 입력 (사칙연산만 허용합니다.) ex) 20 + 10");
		System.out.print(" >> ");
		inputString = scanner.nextLine();
		inputString = inputString.replace(" ", "");

		int numPlus = inputString.indexOf("+");
		int numMinus = inputString.indexOf("-");
		int numMultiply = inputString.indexOf("*");
		int numDivide = inputString.indexOf("/");

		String frontNum = "";
		String backNum = "";

		try {
			if (numPlus != -1) {
				frontNum = inputString.substring(0, numPlus);
				backNum = inputString.substring(numPlus + 1);

				Integer frontNumInteger = Integer.parseInt(frontNum);
				Integer backNumInteger = Integer.parseInt(backNum);

				System.out.println("[result] " + (frontNumInteger + backNumInteger));
			} else if (numMinus != -1) {
				frontNum = inputString.substring(0, numMinus);
				backNum = inputString.substring(numMinus + 1);

				Integer frontNumInteger = Integer.parseInt(frontNum);
				Integer backNumInteger = Integer.parseInt(backNum);

				System.out.println("[result] " + (frontNumInteger - backNumInteger));
			} else if (numMultiply != -1) {
				frontNum = inputString.substring(0, numMultiply);
				backNum = inputString.substring(numMultiply + 1);

				Integer frontNumInteger = Integer.parseInt(frontNum);
				Integer backNumInteger = Integer.parseInt(backNum);

				System.out.println("[result] " + (frontNumInteger * backNumInteger));
			} else if (numDivide != -1) {
				frontNum = inputString.substring(0, numDivide);
				backNum = inputString.substring(numDivide + 1);

				Double frontNumDouble = Double.parseDouble(frontNum);
				Double backNumDouble = Double.parseDouble(backNum);

				System.out.println("[result] " + ((int) ((frontNumDouble / backNumDouble) * 100) / 100.0));
			} else {
				System.out.println("[error] Incorrect formula.");
			}
		} catch (NumberFormatException e) {
			System.out.println("[error] Incorrect formula.");
		}

		scanner.close();

	}
}