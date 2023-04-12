package example;

import java.text.DecimalFormat;

public class OperatorExample {
	public static void main(String[] args) {
		// 245678초를 일시분초 형식으로 변환하여 출력하세요.

		int initialValue = 245678;
		final int VALUE_SECOND = 1;
		final int VALUE_MINUTE = VALUE_SECOND * 60;
		final int VALUE_HOUR = VALUE_MINUTE * 60;
		final int VALUE_DAY = VALUE_HOUR * 24;

		int sec, min, hour, day, remain;

		remain = initialValue;

		day = remain / VALUE_DAY;
		remain %= VALUE_DAY;

		hour = remain / VALUE_HOUR;
		remain %= VALUE_HOUR;

		min = remain / VALUE_MINUTE;
		remain %= VALUE_MINUTE;

		sec = remain;
		System.out.println("245678 sec => " + day + "일 " + hour + "시 " + min + "분 " + sec + "초");

		System.out.println("===============================================");
		// 한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요.
		// 단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		int airplanePrice = 150_000_000;
		int count = 20;

		String totalPrice;

		DecimalFormat decFormat = new DecimalFormat("###,###");

		totalPrice = count >= 15 ? decFormat.format(airplanePrice * 0.75 * count) : decFormat.format(airplanePrice * count);
		System.out.println("지불해야 할 금액 : " + totalPrice);

		System.out.println("===============================================");
	}
}