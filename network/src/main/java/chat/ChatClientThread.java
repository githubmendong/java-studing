package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {


    private Socket socket;

    public ChatClientThread(Socket socket) {
        this.socket = socket;
    }

    /**
     *
     */
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            while (true) {
                String message = br.readLine();
                if (message == null) {
                    break;
                }
                System.out.println(message);
            }
        } catch (SocketException ex) {
            ChatClient.log("" + ex);
        } catch (IOException ex) {
            ChatClient.log("다음 이유로 프로그램을 종료 합니다 :" + ex);
        } finally {
            System.exit(0);
        }
    }
}