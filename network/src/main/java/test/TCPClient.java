package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class TCPClient {
    private static final String SERVER_IP = "127.0.0.1"; // 서버 IP 주소
    private static final int SERVER_PORT = 5000;       // 서버 포트 번호

    public static void main(String[] args) {
        Socket socket = null;
        try {
            // 1. 소켓 생성
            socket = new Socket();

            // 1-1. 소켓 버퍼 사이즈 확인
            int rcvBufferSize = socket.getReceiveBufferSize();
            int sndBufferSize = socket.getSendBufferSize();

            System.out.println(rcvBufferSize + " : " + sndBufferSize);

            // 1-2 소켓 버퍼 사이즈 변경
            socket.setReceiveBufferSize(1024 * 10);

            rcvBufferSize = socket.getReceiveBufferSize();
            sndBufferSize = socket.getSendBufferSize();
            System.out.println(rcvBufferSize + " : " + sndBufferSize);

            // 1-3. SO_NODELAY (Nagle Algorithm off)
            socket.setTcpNoDelay(true);

            //1-4. SO_TIMEOUT
            socket.setSoTimeout(3000);


            // 2. 서버 연결
            socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

            // 3. IO Stream 받아오기
            InputStream is = socket.getInputStream();    // 입력 스트림
            OutputStream os = socket.getOutputStream(); // 출력 스트림

            // 4. 데이터 쓰기
            String data = "Hello World";
            os.write(data.getBytes("utf-8")); // 문자열 데이터를 바이트로 변환하여 전송

            // 5. 데이터 읽기
            byte[] buffer = new byte[256];   // 읽어온 데이터를 담을 버퍼
            int readByteCount = is.read(buffer); // blocking: 서버로부터 데이터를 읽음

            if (readByteCount == -1) {
                // 서버가 정상적으로 close() 호출하여 연결을 끊음
                System.out.println("[client] closed by server");
                return;
            }

            // 읽어온 데이터를 문자열로 변환하여 출력
            data = new String(buffer, 0, readByteCount, "utf-8");
            System.out.println("[client] received : " + data);

        } catch (SocketException e) {
            // 서버에서 갑작스럽게 연결이 끊어진 경우
            System.out.println("[client] suddenly closed by server");
        } catch (SocketTimeoutException e) {
            System.out.println("TIMEOUT");
        } catch (IOException e) {
            // IO 작업 중 예외 발생한 경우
            System.out.println("[client] error " + e);
        }
        // 소켓 단계에서 파이널 문이 필요한가? Q. try-with-resources
    }
}
