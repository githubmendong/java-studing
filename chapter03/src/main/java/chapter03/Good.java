package chapter03;

public class Good {
	public static int countOfGood = 0;
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
//	public Good(int price) {
//		this.price = price;
//	}
	
	public Good() {
		// 내부에서는 클래스 이름 생략 가능 
//		Good.countOfGood++;
		countOfGood++;
	}
	
	// --
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}
	
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	
}
