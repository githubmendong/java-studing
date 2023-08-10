package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		try {
			int result = ( 1 + 2 + 3 ) / b;
			
		} catch (ArithmeticException ex) {
			System.out.println("오류 발생" + 	ex);
			
			/*   예외 처리 */
			//1. 로깅
			System.out.println("error:" + ex);
			
			//2. 사과
			System.out.println("미안합니다...");
			
			//3. 정상종료 0: 정상 종료 1:비정상종료 
//			System.exit(1);
			
			return;
		
		} finally {
			//option
			System.out.println("자원정리: file close, socket close, ...");
		}
		
		// 원칙적으로 이곳에 코드를 두지 않는다.
		System.out.println("Som4");

	}

}
