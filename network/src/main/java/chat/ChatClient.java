//신동헌
//> Server: 신동헌 님이 채팅에 참여했습니다.
//안녕하세요.
//> 신동헌: 안녕하세요.
//Server: 김동현 님이 채팅에 참여했습니다.
//김동현: 안녕하세요
//김동현: 반갑습니다
//안뇨 압바갑섭
//> 신동헌: 안뇨 압바갑섭
//Server: 이동헌 님이 채팅에 참여했습니다.
//이동헌: 안녕
//Server: 이동헌 님이 채팅을 떠났습니다..
//QUIT:이동헌

package chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9999;

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            socket = new Socket();

            socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

            System.out.println("본인의 닉네임을 입력해주세요:");
            String nickname = scanner.nextLine();
            pw.println("JOIN:" + nickname);

            new ChatClientThread(socket).start();

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();

                if ("quit".equals(input)) {
                    pw.println("QUIT:");
                    break;
                } else {
                    pw.println("MESSAGE:" + input);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
                if (scanner != null) {
                    scanner.close();
                }
            } catch (IOException ex) {
                log("error : " + ex);
            }
        }
    }

    public static void log(String message) {
        System.out.println("[chat client] " + message);
    }
}
