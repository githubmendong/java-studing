// ChatClientApp.java

package chat.gui;

import java.io.*;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp2 {
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
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            new ChatWindow(name, socket).show();
            pw.println("JOIN:" + name);

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