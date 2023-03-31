package example;

public class VariableExample {
	public static void main(String[] args) {
		int width, height;
		double result;

		// 가로의 길이가 7이고 세로의 길이가 10인 사각형의 넓이를 계산하여 출력하세요.
		width = 7;
		height = 10;
		result = width * height;
		System.out.println("사각형의 넓이 : " + result);

		System.out.println("======================================================");
		// 높이가 9이고 밑변의 길이가 7인 삼각형의 넓이를 계산하여 출력하세요.
		width = 7;
		height = 9;
		result = width * height / 2.0;
		System.out.println("삼각형의 넓이 : " + result);

		System.out.println("======================================================");
		// 10명의 전체 몸무게가 759Kg인 경우 평균 몸무게를 계산하여 출력하세요.
		int entireWeight = 759;
		int peopleNum = 10;
		result = (double) entireWeight / peopleNum;
		System.out.println("평균 몸무게 : " + result+"Kg");

		System.out.println("======================================================");
		// 이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		// 총점과 평균을 계산하여 이름, 총점, 평균을 출력하세요.
		// 단, 평균은 소숫점 한자리까지만 출력하고 나머지는 절삭 처리 하세요.
		int kor = 89;
		int eng = 93;
		int math = 95;
		String name = "홍길동";

		int total;
		double average;
		double averageResult;

		total = kor + eng + math;
		average = total / 3.0;
		averageResult = (int) (average * 10) / 10.0;

		System.out.println("이름 : " + name + ", 총점 : " + total + ", 평균: " + averageResult);

		System.out.println("======================================================");
	}
}