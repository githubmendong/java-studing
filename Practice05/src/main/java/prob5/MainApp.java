
//  MainApp.java와 Stack.java는 다음과 같이 주어집니다.
//  Main 클래스를 실행하였을 때 아래와 같은 결과가 출력되도록
//  MyStack 및 MyStackExcepetion 을 작성하세요.

//[출력]
//.
//Java
//!!!
//World
//Hello
//==================================
//Hello
//Prob5.MyStackException: stack is empty


package prob5;

public class MainApp {

	public static void main(String[] args) {
		try {
			MyStack stack = new MyStack(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				String s = stack.pop();
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch ( MyStackException ex) {
			System.out.println( ex );
		}

	}

}
