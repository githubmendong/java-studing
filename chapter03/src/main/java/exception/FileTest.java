package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("hello.txt");
			int data = fis.read();
			System.out.println((char)data);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error"+e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error"+e);
		}finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
