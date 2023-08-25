//문제2.
//        사칙연산 (+, -, *, /)만 가능하고 2개의 피연산자만 입력 받는 정수 계산기를 만드세요.
//        각 사칙연산을 수행하는 각 연산 클래스 Add, Sub, Mul, Div 클래스를 구현하세요.
//        각 클래스는 다음의 인터페이스를 구현합니다.

//public interface Arithmetic {
//	int calculate( int a, int b );
//}
//계산기 본체 클래스는 CalcApp 입니다. 실행결과는 다음과 같습니다.

//실행 결과:
//        두 정수와 연산자를 입력하시오 >> 3 4 +
//        7

package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.print( ">> " );
			String expression = scanner.nextLine();

			if( "quit".equals( expression ) ) {
				break;
			}

			String[] tokens = expression.split( " " );

			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}

			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 1 ] );

			prob02.Arithmetic arithmetic = null;

			/* 코드 작성 */
//            switch (tokens[2]){
//                case "+" :
//                    arithmetic = new Add();
//                    break;
//            }



			int result = arithmetic.calculate(lValue, rValue);
			System.out.println( ">> " + result );
		}

		scanner.close();
	}
}
