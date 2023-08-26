//키보드에서 배열 크기만큼 정수를 입력받고 평균을 구하는 프로그램을 작성하시오

package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[ 5 ];
		double sum = 0;

		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		for (int i = 0; i<intArray.length; i++) {
			System.out.println("정수 입력  : ");
			intArray[i] = scanner.nextInt();
			sum += intArray[i];
		}
		
		
		/* 출력 */
		double ave = sum / intArray.length;
		System.out.println("평균 : " + ave);
		
		/* 자원정리 */
		scanner.close();
	}
}
