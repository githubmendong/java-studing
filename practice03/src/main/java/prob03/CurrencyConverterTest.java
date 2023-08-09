//static 필드와 메소드를 이용하여 달러와 우리나라 원화 사이의 변환을
//해주는 환율 계산기를 만들어 보세요.
//
//실행 결과: 
//백만원은 892.0606601248885달러입니다.
//백달러는 112100.0원입니다.
//

package prob03;

public class CurrencyConverterTest {

	public static void main(String[] args) {
		// 환율을 세팅 합니다.
		CurrencyConverter.setRate(1197.0);

		double dollar = CurrencyConverter.toDollar(1000000.);
		System.out.println("백만원은 " + dollar + "달러 입니다");

		double krw = CurrencyConverter.toKRW(100.);
		System.out.println("백달러는 " + krw + "원 입니다");
	}

}
