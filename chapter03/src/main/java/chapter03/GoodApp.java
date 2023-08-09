package chapter03;

public class GoodApp {
	public static void main(String[] args) {
		Good camera = new Good();
		String a = camera.name = "Nikon";
		int b = camera.price = 40000;
		int c = camera.countStock = 10;
		int d = camera.countSold = 20;

		System.out.println("상품" + (String) a + "가격" + b + "재고" + c + "개수" + d);
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
