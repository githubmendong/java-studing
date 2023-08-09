//java.util.Scanner 클래스를 이용하여 상품을 입력받아 Goods 객체를 생성하고 
//이들을 Goods 객체 배열에 저장하세요. 상품 즉,
//Goods 객체를 3개 입력 받으면 이들을 모두 화면에 출력하세요.

//실행 결과: 
//콜라 1000 10
//사이다 900 40
//맥주 2000 100
//
//콜라(가격:1000원)이 10개 입고 되었습니다.
//사이다(가격: 900원)이 40개 입고 되었습니다.
//맥주(가격: 2000원)이 100개 입고 되었습니다.

package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			String line = scanner.nextLine();
			String[] infos = line.split(" ");

			String name = infos[0];
			int price = Integer.parseInt(infos[1]);
			int count = Integer.parseInt(infos[2]);

			goods[i] = new Goods(name, price, count);
		}
		// 상품 출력
		for (Goods good : goods) {
			System.out.println(good.getName() + "(가격:" + good.getPrice() + "원)이 " + good.getCount() + "개 입고 되었습니다.");
		}
		// 자원정리
		scanner.close();
	}
}
