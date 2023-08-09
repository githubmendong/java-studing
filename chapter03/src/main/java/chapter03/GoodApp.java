package chapter03;

public class GoodApp {
	public static void main(String[] args) {
		// 지역 변수는 매번 초기화야해야
//		int i = 0;
//		System.out.println(i);
		
		Good camera = new Good();
		camera.setName("Nikon");
		camera.setPrice(40000);
		camera.setCountStock(10);
		camera.setCountSold(20);
		
		//정보은닉 (데이터보호)
		camera.setPrice(-1);
		
		//countOfGood test
		Good goods1 = new Good();
		Good goods2 = new Good();
		Good goods3 = new Good();

		System.out.println(Good.countOfGood);
		System.out.println(
							"상품" + camera.getName() +
							"가격" + camera.getPrice() +
							"재고" + camera.getCountStock() +
							"개수" + camera.getCountSold()
							);
//		if(10-1 == 9) {
//			int i = 10;
//		}
//		
//		for(int i = 0; i< 1000000000L; i++) {
//			new Good();
//		}

//		System.out.println(i);

	}
}
