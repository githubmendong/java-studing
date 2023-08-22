//package chat;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ChatServer {
//    private static final int PORT = 9999;
//
//    public static void main(String[] args) {
//        List<PrintWriter> listPrintWriter = new ArrayList<PrintWriter>();
//
//        ServerSocket serverSocket = null;
//
//        try {
//            //1. 소켓 서버 생성
//            serverSocket = new ServerSocket();
//
//            // 2. 바인딩
//            String hostAddress = InetAddress.getLocalHost().getHostAddress();
//            serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
//            log("연결 기다림" + hostAddress + ":" + PORT);
//
//            // 3.요청대기
//            while (true) {
//                //3. wating for connection
//                Socket socket = serverSocket.accept();
//
//                Thread thread = new ChatServerThread(socket, listPrintWriter);
//                thread.start();
//            }
//        } catch (UnknownHostException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            log("Error : " + e);
//        } finally {
//            try {
//                if (serverSocket != null && serverSocket.isClosed() == false) {
//                    serverSocket.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//    public static void log(String log) {
//        System.out.println("챗 서버 : " + log);
//    }
//
//}
