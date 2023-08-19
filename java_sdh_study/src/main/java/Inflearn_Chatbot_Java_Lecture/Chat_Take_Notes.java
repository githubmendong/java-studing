package Inflearn_Chatbot_Java_Lecture;

public class Chat_Take_Notes {
    public static void main(String[] args) {
        // -----------------------------
        // -----------------------------

        // 사용자 1 클라이언트
        //java Chat kim[enter]
        // java Chat kim 서버 접속

        // -----------------------------
        // -------- 네트워크 망 ---------
        // -----------------------------
        // -------- 서버 망 ---------
        // -----------------------------

        //1. 접속을 대기
        //2. 클라이언트가 접속하면 Socket이 나온다.
        //3. [사용자1] 클라이언트가 보낸 "Message"를 일어들인다.
        //4. 서버에 접속하고 모든 클라이언트에 "Message" 메시지를 전송한다.
        // 4 -1  브로드 캐스팅 기법

        // -----------------------------
        // -------- 서버 망 ---------
        // -----------------------------
        // -------- 네트워크 망 ---------
        // -----------------------------

        // 사용자 2
        // java Chat lee [enter]

        // -----------------------------
        // -----------------------------


        // 내가 어떤 정보를 입력하고 있을 떄,
        // 다른 사람이 보낸 데이터가 내 화면에 출력 되야 한다.
        // String line = br.readLine(); blocking
        // System.out.println(line);

        // 동시 채팅을 위해 Thread로 보내야한다.
        // 동시에
        // 다른 사람이 보낸 메시지를 읽어들여서 화면에 출력한다.
        //
        //  Blocking I/O: 주석에서 언급된 br.readLine()은 blocking I/O로,
        //      데이터가 도착할 때까지 대기한다. 동시 채팅을 구현하기 위해서는 이를 비동기로 처리해야 함.

        //  동시성 처리: 동시 채팅을 가능하게 하기 위해 쓰레드(thread)를 활용해야 한다.
        //      Java에서는 Thread 클래스나 Runnable 인터페이스를 활용하여 멀티스레딩을 구현할 수 있다.

        //  네트워크 통신: 실제로 채팅 어플리케이션을 개발하려면 네트워크 프로그래밍을 이해해야 한다.
        //      Java에서는 Socket과 같은 클래스를 활용해 클라이언트와 서버 간의 통신을 구현할 수 있다.
    }
}
