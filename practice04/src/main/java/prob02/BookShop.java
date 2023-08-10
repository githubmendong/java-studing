//[문제2]
//주어진 BookShop.java를 실행했을 때 다음과 같은 실행결과가 나타나도록 아래의 문제설명을 참
//고하여 Book.java 를 작성하고 BookShop.java를 완성하세요.
//

//
//<<문제설명>>
//다음과 같은 조건을 만족하도록  작성합니다.
//
//Book클래스
//Book
//int bookNo
//String title
//String author
//int stateCode
//Book(int bookNo,String title,String author)
//rent() : void
//print() : void
//
//1.	멤버변수는 다음과 같으며 모든 멤버 변수는 초기값을 지정하지 않습니다.
//int bookNo: 번호
//String title: 제목
//String author: 작가
//int stateCode: 상태코드(대여유무를 나타내는 상태코드)
//2.	생성자는 BookShop의 main메소드를 참고하여 각 멤버변수를 초기화할 수 있도록 작업합니다. 단, stateCode는 생성자 호출 시에 1로 세팅 되도록 설정합니다.
//3.	각각의 메소드는 아래의 기능을 구현하도록 작성합니다.
//-	모든 메소드는 public으로 작성합니다.
//-	bookNum, title, genre에 대해서는 모든 setter/getter메소드를 추가하세요.
//-	rent() : 대여기능을 수행하는 메소드로 
//Book클래스의 stateCode를 0으로 변경하며  “_______이(가) 대여 됐습니다.”메시지가 출력되도록 작성합니다.이때 ______는 책제목이 출력되도록 작성합니다.
//-	print(): 책의 정보가 출력형태와 같이 출력될 수 있도록 작성합니다. 이때 대여 유무는 Book클래스의 stateCode가 1이면 “재고있음”으로 0이면 “대여중”으로 출력되도록 설정합니다.
//
//BookShop클래스
//    주어진 소스에 표시된 (1)과 (2)에 해당하는 내용을 아래의 조건에 맞게 작성합니다.
//1.	(1)의 부분은 BookShop.java에서 입력받은 책 번호에 해당 책을 배열에서 찾아 rent메소드가 호출되도록 작성합니다.
//2.	(2)의 부분은 메소드의 매개변수로 전달된 배열에 저장된 모든 Book 객체의 정보를 출력할 수 있도록 작성합니다.
//
//<<주의사항>>
//1.	주어진  BookShop.java는 수정하지 않습니다.
//2.	멤버변수에 초기값을 지정하지 마십시오
//3.	Book클래스의 rent메소드에서 stateCode를 변경해야 합나다.
//4.	Book클래스의 print메소드의 실행결과가 주어진 조건과 맞게 출력하도록 하세요

package prob02;

import java.util.Scanner;

public class BookShop {

	public static void main(String[] args) {
		Book[] books = new Book[10];

		books[0] = new Book(1, "트와일라잇", "스테파니메이어", 0);
		books[1] = new Book(2, "뉴문", "스테파니메이어", 0);
		books[2] = new Book(3, "이클립스", "스테파니메이어", 0);
		books[3] = new Book(4, "브레이킹던", "스테파니메이어", 0);
		books[4] = new Book(5, "아리랑", "조정래", 0);
		books[5] = new Book(6, "젊은그들", "김동인", 0);
		books[6] = new Book(7, "아프니깐 청춘이다", "김난도", 0);
		books[7] = new Book(8, "귀천", "천상병", 0);
		books[8] = new Book(9, "태백산맥", "조정래", 0);
		books[9] = new Book(10, "풀하우스", "원수연", 0);

		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		int num = scanner.nextInt();
		scanner.close();

		// (1) 입력된 번호에 맞는 책을 찾아 대여 되었음(상태코드=0)을 체크 합니다.
		if (num > 0 && num <= books.length) {
			books[num - 1].rent();
		}

		// (2) Book 객체의 정보를 출력
		System.out.println("*****도서 정보 출력하기******");
		displayBookInfo(books);
	}

	private static void displayBookInfo(Book[] books) {
		for (Book book : books) {
			book.print();
		}
	}
}