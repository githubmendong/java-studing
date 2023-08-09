package prob03;

public class CurrencyConverter {
	private static double rate;
	

	public static void setRate(double r) {
		rate = r;
	}

	public static double toDollar(double won) {
		// TODO Auto-generated method stub
		return won/rate;
	}

	public static double toKRW(double dollar) {
		// TODO Auto-generated method stub
		return dollar * rate;
	}

}
