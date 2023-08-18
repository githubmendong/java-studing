package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        try {
            // 1. Server Socket 생성
            ServerSocket serverSocket = new ServerSocket();

            // 2. 바인딩(Binding)
            // Socket에 InetSocketAddress(IPAddress + port)를 바인딩한다.
            // IPAddress: 0.0.0.0 - 모든 네트워크 인터페이스에 바인딩
            serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);

            // 3. accept
            // 클라이언트의 연결을 기다린다. 연결이 성공하면 해당 클라이언트와 통신하는 소켓을 반환한다.
            Socket socket = serverSocket.accept(); // blocking

            // 이후에는 socket을 이용하여 클라이언트와 통신하는 로직을 추가해야 한다.

        } catch (IOException e) {
            System.out.println("[server] error: " + e);
        }
    }
}
