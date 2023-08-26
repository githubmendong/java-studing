//키보드에서 정수로 된 돈의 액수를 입력 받아 오만 원권, 만원 권, 오천 원권, 천원 권,
//500원 동전, 100원 동전, 50원 동전, 10원 동전, 1원 동전 각 몇 개로 변환 되는지 작성하시오.

package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		System.out.println("금액 : ");
		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] countmoney = new int[MONEYS.length];
		/* 코드 작성 */

		for (int i = 0; i < MONEYS.length; i++) {
			countmoney[i] = money / MONEYS[i]; // 해당 화폐 종류 개수 계산
			money %= MONEYS[i]; // 남은 금액 갱신
		}

		for (int i = 0; i < MONEYS.length; i++) {
			System.out.println(MONEYS[i] + "원: " + countmoney[i] + "개");
		}

		scanner.close();
	}
}