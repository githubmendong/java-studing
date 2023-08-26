package chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
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
        try {
            InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            ChatServer.log("connected by client[" + remoteSocketAddress.getAddress().getHostAddress() + ":" + remoteSocketAddress.getPort() + "]");

            // 2
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            while (true) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {

                    ChatServer.log("Error while reading from client: " + e);
                    chatQuit(pw);
                    return;

                }
                if (line == null) {
                    chatQuit(pw);
                    ChatServer.log("closed by client");
                    break;
                }

                String[] tokens = line.split(":");
                if ("JOIN".equals(tokens[0])) {
                    chatJoin(tokens[1], pw);
                } else if ("MESSAGE".equals(tokens[0])) {
                    chatMessage(tokens[1]);
                } else if ("QUIT".equals(tokens[0])) {
                    chatQuit(pw);
                    break;
                }
            }
        } catch (SocketException ex) {

            chatQuit(pw);
            ChatServer.log("Client unexpectedly disconnected: " + ex);
            return;

        } catch (IOException ex) {

            chatQuit(pw);
            ChatServer.log("Client unexpectedly disconnected: " + ex);
            return;

        } finally {
            try {
                if (socket != null &&
                        socket.isClosed() == false) {
                    socket.close();
                }
            } catch (IOException ex) {
                ChatServer.log("Error " + ex);
            }
        }
    }

    private synchronized void chatJoin(String name, PrintWriter pw) {
        this.name = name;
        listPrintWriter.add(pw);
        ChatServer.log(name + " 참여했습니다!");
        broadcast("Server: " + name + " 님이 채팅에 참여했습니다.");
        ChatServer.increaseParticipantCount();  // 참여자 수 증가
    }


    private synchronized void chatMessage(String message) {
        ChatServer.log(name + ": " + message);
        broadcast(name + ": " + message);
    }

    private synchronized void chatQuit(PrintWriter pw) {
        if (name != null) {
            ChatServer.log(name + " 채팅을 떠났습니다.");
            listPrintWriter.remove(pw);
            broadcast("Server: " + name + " 님이 채팅을 떠났습니다..");
            ChatServer.decreaseParticipantCount();  // 참여자 수 감소
        }
        if (pw != null) {
            pw.close();
        }
        broadcast("QUIT:" + name);
    }


    // 브로드캐스트 메시지를 모든 클라이언트에게 보냄
    private synchronized void broadcast(String message) {
        for (PrintWriter writer : listPrintWriter) {
            writer.println(message);
        }
    }

}
