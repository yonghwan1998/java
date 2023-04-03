package example;

import java.util.Scanner;

//키보드로 정수값을 계속 입력받아 합계를 계산하여 출력하는 프로그램을 작성하세요.
//단, 입력된 정수값이 0인 경우 입력을 종료하고 합계 출력
//ex) 정수값 입력[0:종료] >> 10
//    정수값 입력[0:종료] >> 20
//    정수값 입력[0:종료] >> 30
//    정수값 입력[0:종료] >> 0
//    [결과]합계 = 60
public class TotalTwoExample {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int sum = 0;
		int inputNum = 0;

		while (true) {
			System.out.println("정수값 입력 [0:종료] >>");
			inputNum = scanner.nextInt();
			if (inputNum == 0) {
				break;
			} else {
				sum += inputNum;
			}
		}
		System.out.println("[결과] 합계 = " + sum);
		scanner.close();
	}
}