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
		
		camera.showInfo();
		camera.setPrice(50000);
		int discountPrice = camera.calcDiscountPrice(0.5);
		System.out.println(discountPrice);
		
		//생성자생성
		//객체생성은 파라미터만 다르게 해서 일관성 있게 생성 
		Good tv = new Good("TV", 40000, 10, 20);
		tv.showInfo();
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
