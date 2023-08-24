package chapter04;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectTest01 {

	public static void main(String[] args) {
<<<<<<< HEAD
        ServerSocket serverSocket = null;

        try {
            // TCP 소켓 객체를 생성
            serverSocket = new ServerSocket();

            // 로컬 컴퓨터 IP 주소 얻기
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP 주소 : " + local.getHostAddress());

            // 소켓을 호스트의 포트와 연결(bind)
            // InetSocketAddress : IP 소켓 주소(IP 주소 + 포트 넘버)
            serverSocket.bind(new InetSocketAddress("localhost", 10001));
            System.out.println("[서버] 연결 기다림");

            // 클라이언트로부터 소켓 연결이 올 때까지 대기(Accept)
            Socket socket = serverSocket.accept();
            System.out.println("[서버] 연결됨");

            // 클라이언트와 연결을 종료
            socket.close();
            serverSocket.close();
            if (serverSocket != null && serverSocket.isClosed() == false) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(serverSocket);
            if(serverSocket != null && serverSocket.isClosed() == false) {
                try {
                    serverSocket.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

=======
		Point point = new Point();

//		Class klass = point.getClass();
		System.out.println(point.getClass());
		System.out.println(point.hashCode()); 	//address X
												// reference x
												// address 기반의 해싱값 o

		System.out.println(point.toString()); 	//getClass() + "@" + hashCode()
		System.out.println(point);
>>>>>>> branch 'master' of https://github.com/githubmendong/java-studing.git
	}

}
