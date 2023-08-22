package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {
    private Socket socket;
    private String name;
    private List<PrintWriter> listPrintWriter;


    public ChatServerThread(Socket socket, List<PrintWriter> listPrintWriter) {
        this.socket = socket;
        this.listPrintWriter = listPrintWriter;
    }

    /**
     *
     */
    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;

        InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
        ChatServer.log("connected by client[" + remoteSocketAddress.getAddress().getHostAddress() + ":" + remoteSocketAddress.getPort() + "]");

        // 2
        br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
        try {
            super.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
