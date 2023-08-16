
//구구단 중에 특정 곱셈을 만들고 그 답을 선택하는 프로그램을 작성하는 문제입니다.
//		답을 포함하여 9개의 정수가 아래와 같은 형태로 출력되고 사용자는 답을 골라 입력하게 됩니다.
//		프로그램은 정답 여부를 다시 출력합니다.

//[출력]
//
//		6 x 9 = ?
//
//		81	12	32
//		18	54	4
//		32	6	32
//
//		answer: 54           [입력]
//
//		정답/오답            [출력]

//
//문제 설명 :
//		Gugudan.java 를 완성합니다.
//
//		문제 힌트 및 제한 :
//		1.	문제식은 구구단의 곱셈 중에 랜덤하게 출력되어야 한다.
//		2.	답을 포함 81보다 작은 9개의 정수가 그림과 같은 형태로 출력되어야 한다.
//		3.	사용자의 답을 입력 받아야 한다.
//		4.	결과“정답” 또는 “오답”을 출력하여야 한다.
//		5.	문제에서 주어진 코드의 주석으로 처리된 부분을 완성해서 오류를 모두 수정해야 하고 출력결과도 문제가 원하는 출력결과가 나와야 한다.




package prob01;

import java.util.Scanner;

public class GugudanApp {

	static int resultNumber = 0;

	public static void main(String[] args) {
		int l = randomize(1, 9);
		int r = randomize(1, 9);

		resultNumber = l * r;

		int[] answerNumbers = randomizeAnswers();
		int loc = randomize(0, 8);
		answerNumbers[loc] = resultNumber;

		System.out.println(l + " x " + r + " = ?");

		int length = answerNumbers.length;
		for (int i = 0; i < length; i++) {
			if (i % 3 == 0) {
				System.out.print("\n");
			} else {
				System.out.print("\t");
			}

			System.out.print(answerNumbers[i]);
		}

		System.out.print("\n\n");
		System.out.print("answer:");

		Scanner s = new Scanner(System.in);
		int answer = s.nextInt();
		s.close();

		System.out.println((answer == resultNumber) ? "정답" : "오답");
	}

	private static int randomize(int lNum, int rNum) {
		int random = (int) (Math.random() * rNum) + lNum;
		return random;
	}

	private static int[] randomizeAnswers() {
		final int COUNT_ANSWER_NUMBER = 9;
		int[] boardNumbers = new int[COUNT_ANSWER_NUMBER];

		for (int i = 0; i < COUNT_ANSWER_NUMBER; i++) {
			boardNumbers[i] = randomize(1, 80); // 81보다 작은 수
		}

		return boardNumbers;
	}

}
