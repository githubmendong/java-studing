// ChatClientApp.java

package chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
//	private static final String SERVER_IP = "127.0.0.1";
//	private static final int SERVER_PORT = 8000;

	public static void main(String[] args) throws IOException {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.println("대화명을 입력하세요.");
			System.out.print("> ");
			name = scanner.nextLine();

			if (name.isEmpty() == false ) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		scanner.close();

//		//1. create socket
//        Socket socket = new Socket()
//		//2. connect server
//		//3. join protocol 진행
//		String line = "JOIN:OK";
//		if("JOIN:OK".equals(line)) {
//			new ChatWindow(name).show();
//		}



        // Create a socket and connect to the server
        Socket socket = new Socket(ChatClient.SERVER_IP, ChatClient.SERVER_PORT);


        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);


        pw.println("JOIN:" + name);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        String line = br.readLine();


        if("JOIN:OK".equals(line)) {
            new ChatWindow(name).show();
        }
    }
}