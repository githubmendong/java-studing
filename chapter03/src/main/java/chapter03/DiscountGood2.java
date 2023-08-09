package chapter03;

import mypackage.Good2;

public class DiscountGood2 extends Good2{
	private float discountRate = 0.5f;
	
	
	public int getDiscountPrince() {
		// protected는 자식에서 접근 할 수 있다.
		int dicountRate = (int) (discountRate * price);
		
		return dicountRate;
	}
}
