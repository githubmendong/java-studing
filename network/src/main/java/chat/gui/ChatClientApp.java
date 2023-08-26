// ChatClientApp.java
// 시간추가
package chat.gui;

import java.io.*;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9000;

    public static void main(String[] args) throws IOException {
        String name = null;
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;

        try {
            while (true) {
                System.out.println("대화명을 입력하세요.");
                System.out.print("> ");
                name = scanner.nextLine();

                if (name.isEmpty() == false) {
                    break;
                }

                System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
            }

            scanner.close();

            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
            ChatWindow chatWindow = new ChatWindow(name, socket);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            new ChatWindow(name, socket).show();
            chatWindow.increaseParticipantCount();  // 참여자 수 증가
            pw.println("JOIN:" + name);

//            chatWindow.show();
            // memo, 여기 부분에 참여자 수 증가를 해야함
            // 입장 시 -> 값 증가를 해주면 될듯...



        } catch (ConnectException ce) {
            System.out.println("Connection Error : " + ce);
            ce.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}