package example;

public class IfExample {
	public static void main(String[] args) {
		// 변수에 저장된 문자값을 출력하세요.
		// 단, 변수에 저장된 문자값이 소문자인 경우 대문자로 변환하여 출력하세요.
		char mun = 'x';

		if (mun >= 97 && mun <= 122) {
			System.out.println("mun = " + (char) (mun - 32));
		} else {
			System.out.println("mun = " + mun);

		}

		System.out.println("============================================================");
		// 변수에 저장된 정수값이 4의 배수인지 아닌지를 구분하여 출력하세요.
		int num = 345644;

		if (num % 4 == 0) {
			System.out.println("num은 4의 배수 입니다.");
		} else {
			System.out.println("num은 4의 배수가 아닙니다.");
		}

		System.out.println("============================================================");
		// 올해가 평년인지 윤년을 구분하여 출력하세요.
		// => 년도를 4로 나누어 나머지가 0인 경우 윤년
		// => 위 조건을 만족하는 년도 중 100으로 나누어 나머지가 0인 경우 평년
		// => 위 조건을 만족하는 년도 중 400으로 나누어 나머지가 0인 경우 윤년
		int year = 2023;

		int number4 = 4;
		int number100 = 100;
		int number400 = 400;

		number4 = year % number4;
		number100 = year % number100;
		number400 = year % number400;

		if (number4 == 0 && number100 != 0 && number400 == 0) {
			System.out.println("윤년입니다.");
		} else {
			System.out.println("평년입니다.");
		}

		System.out.println("============================================================");
		// 이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		// 총점과 평균, 학점을 계산하여 이름, 총점, 평균, 학점을 출력하세요.
		// => 국어,영어,수학 점수 중 하나라도 0~100 범위가 아닌 경우 프로그램 강제 종료
		// System.exit(0) : 프로그램을 강제로 종료하는 메소드
		// => 평균을 이용한 학점 계산 : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
		// => 평균은 소숫점 두자리까지만 출력하고 나머지는 절삭 처리 하세요.
		String name = "홍길동";
		int kor = 89, eng = 93, mat = 95;
		int total = 0;
		double average = 0;
		String score = "";

		if (kor < 0 || kor > 100) {
			System.out.println("잘못된 점수가 입력됐습니다.");
			System.exit(0);
		} else if (eng < 0 || eng > 100) {
			System.out.println("잘못된 점수가 입력됐습니다.");
			System.exit(0);
		} else if (mat < 0 || mat > 100) {
			System.out.println("잘못된 점수가 입력됐습니다.");
			System.exit(0);
		} else {
			total = kor + eng + mat;
			average = (int) ((total / 3.0) * 100) / 100.0;

			if (average >= 90) {
				score = "A";
			} else if (average >= 80) {
				score = "B";
			} else if (average >= 70) {
				score = "C";
			} else if (average >= 60) {
				score = "D";
			} else {
				score = "F";
			}
		}

		System.out.println("이름 : " + name + ", 총점 : " + total + ", 평균 : " + average + ", 학점 : " + score);

		System.out.println("============================================================");
	}
}