package chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    //1. 아이피와 포트 고정
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9999;

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = null;

        try {
            // 1. 키보드 연결
            scanner = new Scanner(System.in);

            // 2. socket 생성
            socket = new Socket();

            // 3. 서버 연결
            socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

            // 4. reader / writer 생성
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

            System.out.println(" 본인의 닉네임을 입력해주세요  :");
            String nickname = scanner.nextLine();
            pw.println("JOIN:" + nickname);
            pw.println(nickname + "님이 채팅에 참여했씁니다.");
//            pw.flush();

            //스레드 시작
            new ChatClientThread(socket).start();

            // 7.키보드 입력 처리
            while (true) {
                System.out.println(" > ");
                String input = scanner.nextLine();

                if ("quit".equals(input) == true) {
                    //8. quit 프로토콜 처리
                    break;
                } else {
                    //9. 메시지 처리
                }
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            {
                //10. 자원정리
                try {
                    if (socket != null && socket.isClosed() == false) {
                        socket.close();
                    }
                    if (scanner != null) {
                        scanner.close();
                    }
                } catch (IOException ex) {
                    System.out.println("error : " + ex);
                }
            }
        }

    }
}
