package basic;

public class IfApp {

	public static void main(String[] args) {

		int num = 0;
		String grade;

		if (num >= 90) {
			grade = "A";
			System.out.println(grade);
		} else if (num >= 80) {
			grade = "B";
			System.out.println(grade);

		} else if (num >= 70) {
			grade = "C";
			System.out.println(grade);

		} else if (num >= 60) {
			grade = "D";
			System.out.println(grade);

		} else {
			grade = "F";
			System.out.println(grade);

		}

	}

}