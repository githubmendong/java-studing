package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("some code1...");
		System.out.println("some code2...");
		if (3 - 3 == 0) {
			throw new MyException();
		}
		if (1 - 1 == 0) {
			throw new IOException();
		}

//        try {
//            // 예외 객체를 던짐
//            throw new IOException();
//        } catch (IOException e) {
//            // 예외를 처리하는 코드 추가
//            System.out.println("IOException caught: " + e.getMessage());
//        }

		System.out.println("some code1...");
		System.out.println("some code2...");
	}
}
