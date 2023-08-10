package prob02;

public class Book {
	public int bookNo;
	public String title;
	public String author;
	public int stateCode; //상대 코드 1이면 재고 있음
	
	public Book(int bookNo, String title, String author, int stateCode) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1; //디폴트 값 
	}
	
	public void rent() {
		this.stateCode = 0;
		System.out.println(title + "이 대여되었습니다.");
	}
	public void print() {
		System.out.println("책 제목:" + title +
		                   ", 작가:" + author +
		                   ", 대여 유무:" + (stateCode == 1 ? "재고있음" : "대여중"));
	}

	// Getter와 Setter 메소드
	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}

