package chapter03;

import mypackage.Good2;

public class GoodApp2 {
	public static void main(String[] args) {
		Good2 good = new Good2();
		
		// public : 접근 제한이 없다.
		good.name = "camera";
		
		// protected : 같은 패키지에서 접근이 가능하다. 오류
		//				더 중요한 접근 제어는 자식에서 접근 가능하다.
//		good.price = 10000;
		
		// 디폴트는 같은 패키지에서 접근이 가능하다. 오
//		good.countStock = 10;
		
		//private 는 같은 클래스 에서만 접근 가능하다.(오류
		//goods.countSold = 20;
		
	}

}
