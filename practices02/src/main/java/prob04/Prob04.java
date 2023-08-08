//문자열(String)을 입력 받아, 해당 문자열을 문자 순서를 뒤집어서
//char[]로 반환하는 메소드를 만들고, char[]을 입력 받아 출력하는 메소드를 만드시오.

package prob04;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
		char[] reversed = new char[str.length()];
		
		for(int i = 0; i<str.length(); i++) {
			reversed[i] = str.charAt(str.length() -1 -i);
		}
		return reversed;
	}

	public static void printCharArray(char[] array) {
		/* 코드를 완성합니다 */
		for (char ch : array) {
            System.out.print(ch);
        }
		System.out.println(array);
	}
}