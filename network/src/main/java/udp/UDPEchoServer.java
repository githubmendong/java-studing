package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
    public static final int PORT = 8000;
    public static final int BUFFER_SIZE = 256;
    DatagramSocket socket = null;

    public static void main(String[] args) throws SocketException {
        try {
            //1. 소켓 생성
            DatagramSocket socket = new DatagramSocket(PORT);

            while (true) {
                //2. Data 수신
                DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
                socket.receive(rcvPacket); //Blocking

                byte[] rcvData = rcvPacket.getData();
                int offset = rcvPacket.getLength();

                new String(rcvData, 0, offset, "utf-8");

                //3. 송신
                byte[] sndData = message.getBytes("utf-8");
                DatagramPacket sndPacket = new DatagramPacket(sndData,
                        sndData.length, rcvPacket.getAddress(), rcvPacket.getPort());

                socket.send(sndPacket);
            }
        } catch (SocketException ex) {
            System.out.println("error " + ex);
        } catch (IOException ex) {
            System.out.println("error " + ex);
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

}
