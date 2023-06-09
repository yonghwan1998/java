package example;

import java.util.Scanner;

// 컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
// => 1~100 범위의 정수 난수값을 제공받도록 작성
// => 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
// => 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
// => 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
// => 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
// => 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성

public class UpAndDownExample {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int inputNum = 0;
		int comNum = (int) (Math.random() * 100) + 1;
		int failCount = 0;

		start: while (true) {
			System.out.print("(1~100) 범위의 정수를 입력하세요. \n> ");
			inputNum = scanner.nextInt();
			if (inputNum < 1 || inputNum > 100) {
				System.out.println("\n[error] 정상적이지 않은 값이 입력됐습니다.");
				continue start;
			}
			if (failCount == 9) {
				System.out.println("\n실패! [정답은 " + comNum + "입니다.]");
				break;
			} else if (inputNum == comNum) {
				System.out.println("\n성공! [정답은 " + comNum + "입니다.]\n" + "[실패 횟수는 " + failCount + "회 입니다.]");
				break;
			} else if (inputNum > comNum) {
				failCount++;
				System.out.println();
				System.out.println("현재 실패 횟수는 " + failCount + "회 입니다. (남은 도전 횟수 : " + (10 - failCount) + ")");
				System.out.println("입력된 값 : " + inputNum);
				System.out.println("더 작은 값을 입력하세요.");
			} else if (inputNum < comNum) {
				failCount++;
				System.out.println();
				System.out.println("현재 실패 횟수는 " + failCount + "입니다. (남은 도전 횟수 : " + (10 - failCount) + ")");
				System.out.println("입력된 값 : " + inputNum);
				System.out.println("더 큰 값을 입력하세요.");
			}
		}
		scanner.close();

	}
}