//[문제3]
//아래 3개의 클래스로부터 공통부분을 뽑아서 Unit라는 클래스를 만들고
//Unit 클래스를 상속받도록 코드를 고쳐 보세요. 
//
//주의 사항 :
//1.	Unit 클래스를 새로 작성합니다.
//2.	기존 3개의 클래스는 문제의 조건에 맞게 수정 되어야 합니다.
//3.	메소드의 구체적 구현은 하지 않습니다.
//4.	실행되지 않고 클래스만 구현하세요. 

package prob03;

public class DropShip extends Unit{
	// 현재 위치
	private int x;
	private int y;

	void load() {
		/* 선택된 대상을 태운다.*/ 
	}
	
	void unload() {
		/* 선택된 대상을 내린다.*/ 
	}
}