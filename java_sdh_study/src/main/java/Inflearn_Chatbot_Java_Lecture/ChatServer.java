package Inflearn_Chatbot_Java_Lecture;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());

        while (true) {

            Socket socket = new Socket();

            ChatThread chatThread = new ChatThread(socket, outList); // Sharing 객체
            chatThread.start();
        }
    }
}

class ChatThread extends Thread {
    private Socket socket;
    private List<PrintWriter> outList;
    private PrintWriter out;
    private BufferedReader in;

    public ChatThread(Socket socket, List<PrintWriter> outList) {
        this.socket = socket;
        this.outList = outList;
        //1. socket으로 부터 일어 들일 수 있는 객체를 얻는다.
        //2. socket에게 쓰기 위한 객체를 얻는다. (현재 연결된 클라이언트에게 쓰는 객체)

        try {

            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outList.add(out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void run() {
        String line = null;

        try {
            while ((line = in.readLine()) != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outList.remove(out);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //3. 클라이언트가 보낸 메시지를 읽는다.
        //4. 접속된 모든 클라이언트에게 메시지를 보낸다. (현재 접속된 모든 클라이언트에게 쓸 수 있는 개체가 필요하다.)
    }
}
