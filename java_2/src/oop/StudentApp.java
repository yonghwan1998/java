package oop;

public class StudentApp {
	public static void main(String[] args) {

		Student[] students = { new Student(1000, "홍길동", 90, 90), new Student(2000, "임꺽정", 94, 98),
				new Student(3000, "전우치", 91, 80), new Student(4000, "일지매", 76, 82), new Student(5000, "장길산", 84, 86) };


		// 배열의 참조요소에 저장된 객체의 메모리 주소를 차례대로 제공받아 변수에 저장하여
		// 처리하는 향상된 for 구문을 사용하여 일괄처리
		for (Student student : students) {
			student.display();

			// 정적 필드가 public 접근 제한자로 설정된 경우 클래스를 이용하여 접근 가능
			// => 객체로 접근 가능하지만 경고 발생
			// Student.total += student.getTot();//학생 총점을 반환받아 총합계 변수에 누적하여 저장
			// 정적 필드가 private 접근 제한자로 설정된 경우 메소드를 이용하여 접근 가능
			// => 정적 메소드는 객체가 아닌 클래스를 이용하여 호출 가능
			Student.setTotal(Student.getTotal() + student.getTot());
		}
		System.out.println("==============================================================");
		
		// 모든 학생들의 점수 합계를 계산하여 출력
		// System.out.println("총합계 = "+Student.total);
		System.out.println("총합계 = " + Student.getTotal());
		System.out.println("==============================================================");
	}
}