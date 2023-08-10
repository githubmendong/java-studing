//PrinterTest 클래스에서 Printer 객체를 생성하고 println()
//메소드를 호출해서 파라미터 값을 출력하려고 합니다.
//출력 결과에 맞게 Printer 클래스를 구현하세요.

//실행결과
//
//10
//true
//5.7
//홍길동

package prob01;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();

		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
	}
}