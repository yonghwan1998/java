package example;

public class ArrayExample {
	public static void main(String[] args) {
		
		// 사람들의 나이를 저장한 배열 생성하여 참조변수에 저장
		int[] age = { 27, 16, 22, 36, 57, 60, 43, 23, 14, 29, 44, 52, 59, 51, 39, 33, 11 };

		// 배열에 저장된 모든 사람들의 나이 평균을 계산하여 출력하세요.

		int sum = 0;
		int average = 0;

		for (int i = 0; i < age.length; i++) {
			sum += age[i];
		}
		average = sum / age.length;

		System.out.println("모든 사람들의 나이 평균은 " + average + "세이다.");

		System.out.println("===============================================================");
		
		// 배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
		// ex) 10대 = 3명
		// 20대 = 4명
		// ...
		// 60대 = 1명

		// count[0] - 60대, count[1] - 50대, count[2] - 40대, count[3] - 30대, count[4] - 20대, count[5] - 10대

		int primeAge = 0;
		for (int i = 0; i < age.length; i++) {
			if (primeAge < age[i]) {
				primeAge = age[i];
			}
		}

		int countArray = primeAge / 10;
		int[] count = new int[countArray];

		for (int i = 0; i < age.length; i++) {
			int temp = age[i] / 10;
			int temp2 = primeAge / 10;

			for (int j = 0; j < primeAge; j++) {
				if (temp == temp2 - j) {
					count[j]++;
				}
			}
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(((i + 1) * 10) + "대 = " + count[count.length - 1 - i] + "명");
		}

		System.out.println("===============================================================");
	}

}
