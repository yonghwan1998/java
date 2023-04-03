package basic;

// while : 조건에 의해 명령을 반복 실행
// => 반복의 횟수가 명확하지 않은 경우 사용하는 반복문
// 형식) while(조건식) { 명령; 명령; ... }
// => 조건식의 결과가 참인 경우 명령을 반복 실행하고 거짓인 경우 반복문 종료
// => 조건식 생략 불가능
// => 블럭 내부에 작성된 명령을 0번 이상 실행

// 형식) do { 명령; 명령; ... } while(조건식)
// => 블럭 내부에 작성된 명령을 1번 이상 실행

public class WhileApp {
	public static void main(String[] args) {

		// "Java Programming"를 화면에 5번 출력하는 프로그램 작성
		int i = 1;
		while (i <= 5) {
			System.out.println("Java Programming");
			i++;
		}
		System.out.println("==============================================================");

		// 1~100 범위의 정수들의 합계를 계산하여 출력하는 프로그램 작성

		int total = 0;
		i = 1;
		do {
			total += i;
			i++;
		} while (i <= 100);

		System.out.println("1~100 범위의 정수들의 합계 = " + total);
		System.out.println("==============================================================");

		// A4 용지를 반으로 계속 접어 펼쳤을 경우 사각형 모양의 갯수가 500개 이상이 만들어
		// 지려면 몇 번 접어야 되는지를 계산하여 출력하는 프로그램 작성

		int count = 0;
		int recNum = 1;
		while (recNum < 500) {
			count++;
			recNum *= 2;
		}

		System.out.println(count + "번 접으면 " + recNum + "개의 사각형이 만들어집니다.");
		System.out.println("==============================================================");

		// 1~X 범위의 정수들의 합계가 300 이상이 만들어지려면 X가 얼마인지 계산하여 출력하는

		int sum = 0;
		int num = 0;
		while (sum < 300) {
			num++;
			sum += num;
		}
		System.out.println("1~" + num + " 범위의 정수들의 합계 = " + sum);
		System.out.println("==============================================================");
	}
}