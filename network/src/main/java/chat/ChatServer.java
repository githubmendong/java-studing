//챗 서버 : connected by client[127.0.0.1:52971]
//챗 서버 : 신동헌 참여했습니다!
//챗 서버 : 신동헌: 안녕하세요.
//챗 서버 : connected by client[127.0.0.1:52975]
//챗 서버 : 김동현 참여했습니다!
//챗 서버 : 김동현: 안녕하세요
//챗 서버 : 김동현: 반갑습니다
//챗 서버 : 신동헌: 안뇨 압바갑섭
//챗 서버 : connected by client[127.0.0.1:52981]
//챗 서버 : 이동헌 참여했습니다!
//챗 서버 : 이동헌: 안녕
//챗 서버 : 이동헌 채팅을 떠났습니다.

package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        List<PrintWriter> listPrintWriter = new ArrayList<PrintWriter>();

        ServerSocket serverSocket = null;

        try {
            //1. 소켓 서버 생성
            serverSocket = new ServerSocket();

            // 2. 바인딩
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));
            log("연결 기다림" + hostAddress + ":" + PORT);

            // 3.요청대기
            while (true) {
                //3. wating for connection
                Socket socket = serverSocket.accept();

                Thread thread = new ChatServerThread(socket, listPrintWriter);
                thread.start();
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            log("Error : " + e);
        } finally {
            try {
                if (serverSocket != null && serverSocket.isClosed() == false) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void log(String log) {
        System.out.println("챗 서버 : " + log);
    }

}
