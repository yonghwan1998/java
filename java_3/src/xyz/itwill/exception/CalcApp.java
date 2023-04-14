package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcApp {

	public CalcApp() throws InputMismatchException, ArithmeticException {

		Scanner scanner = new Scanner(System.in);

		int inputNum1, inputNum2;
		int cal;

		System.out.print("첫번째 정수값을 입력해 주세요. >> ");
		inputNum1 = scanner.nextInt();

		System.out.print("두번째 정수값을 입력해 주세요. >> ");
		inputNum2 = scanner.nextInt();

		cal = inputNum1 / inputNum2;

		System.out.println(cal);

		scanner.close();

	}

	public static void main(String[] args) {
		try {
			new CalcApp();
		} catch (ArithmeticException e) {
			System.err.println("Input number 'Zero' is not permitted.");
		} catch (InputMismatchException e) {
			System.err.println("Please input type 'Integer'.");
		} catch (Exception e) {
			System.err.println("Unknown error...");
		}

	}
}
