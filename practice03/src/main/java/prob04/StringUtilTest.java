//아래와 같은 출력이 나오도록 StringUtil 클래스를 완성하세요.
//문자열 배열을 입력받아 하나의 문자열로 연결하는 메소드를 작성하십시오.
//
//<< 출력 결과 >>
//결과 문자열 : SuperManBatManSpiderMan
//
//문제 설명 :
// 1. 제시된 소스 코드에 주석으로 된 부분을 채워서 프로그램을 완성합니다.
// 2. String 배열 타입의 파라미터를 받습니다. 
// 3. 인자로 받은 문자열 배열 요소를 하나의 문자열로 결합하고, 결과 문자열을 리턴 합니다.


package prob04;

public class StringUtilTest {

	public static void main(String[] args) {
        String[] strArr = {"SuperMan", "BatMan", "SpiderMan"}; 
        String resultStr = StringUtil.concatenate( strArr );

        System.out.println( "결과 문자열 : " + resultStr ); 
	}

}

