//다음과 같은 2가지 클래스가 제공된다.
//Prob5 클래스를 실행했을 때 실행결과와 같이 나올 수 있도록 MyBase클래스를 작성하시오.
//
//<<실행결과>>
//
//낮에는 열심히 일하자!
//night
//오후도 낮과 마찬가지로 일해야 합니다.
//
//주의 사항 :
//1.	주어진 main메소드를 이용하여 테스트 합니다. 
//2.	주어진 Class Base는 절대로 수정하면 안됩니다.  
//3.	컴파일이 안되거나 Exception 이 발생하는 경우는 무조건 오답으로 처리됩니다.


package prob05;

public class Prob05 {

	public static void main(String[] args) {
		Base base = new MyBase();

		base.service("낮");
		base.service("밤");
		base.service("오후"); 
	}
}

