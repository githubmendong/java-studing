//코드 설명:
//
//ServerSocket를 생성하고 5000 포트에 바인딩합니다.
//클라이언트의 연결을 대기합니다. 연결이 되면 해당 클라이언트와 통신하기 위한 소켓이 생성됩니다.
//클라이언트의 주소 및 포트 정보를 출력합니다.
//데이터 송수신을 위한 InputStream과 OutputStream을 받아옵니다.
//클라이언트로부터 데이터를 읽어오고, 데이터를 처리한 후 클라이언트에게 다시 데이터를 보내는 로직을 구현합니다.
//클라이언트와의 통신이 종료되면 연결을 닫습니다.
//추가로 알아두면 좋은 내용:
//
//실제 운영 환경에서는 멀티스레딩이나 비동기 방식을 사용하여 여러 클라이언트의 동시 접속을 처리해야 합니다.
//데이터 통신 시에는 프로토콜을 정의하고, 메시지의 경계를 처리하는 등의 추가 로직을 고려해야 합니다.
//보안을 위해 SSL/TLS 같은 암호화 기술을 적용하는 것이 좋습니다.

package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
            try {
                InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                String remoteHostAddress = remoteSocketAddress.getAddress().getHostAddress();
                int remotePort = remoteSocketAddress.getPort();

                // 클라이언트의 주소 및 포트 정보 출력
                System.out.println("server connected by client[" + remoteHostAddress + ":" + remotePort + "]");

                // 이후에는 socket을 이용하여 클라이언트와의 데이터 통신 로직을 추가해야함.
                // 예를 들어, InputStream과 OutputStream을 이용하여 데이터를 주고받을 수 있음.

                // 4. IO Stream 받아오기
                OutputStream os = socket.getOutputStream();
                InputStream is = socket.getInputStream();

                while (true){
                    //5. 데이터 읽기
                    byte[] buffer = new byte[256];
                    int readByteCount = is.read(buffer); //blocking

                    if (readByteCount == -1){
                        //클라이언트가 정상적으로 종료 close 호출
                        System.out.println("[sever] closed by client");
                        break;
                    }
                    String data = new String(buffer, 0, readByteCount, "utf-8");
                    System.out.println("[server] received: " + data);

                    // 6. 데이터 쓰기
                    os.write(data.getBytes("utf-8"));
                }


            } catch (SocketException e)
            {
                System.out.println("[server] suddenly closed by client : "+ e);
            }catch (IOException e)
            {
                System.out.println("[server] error : "+ e);
            } finally {
                try {
                    if (serverSocket != null && !serverSocket.isClosed()){
                        serverSocket.close();
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            // 클라이언트와 연결이 성공한 후의 로직

        } catch (IOException e) {
            System.out.println("[server] error: " + e);
        }
    }
}
