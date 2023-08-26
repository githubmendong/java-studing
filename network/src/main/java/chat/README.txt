
1. 요구사항
     1. 단체 채팅방 ( 1개의 방에서 다수의  사용자가  채팅을 한다. )
     2. 닉네임을 등록해야  한다.
     3. 다른 사용자가  입장하면  “OOO님이 입장 하였습니다” 메시지가  출력
     4. 다른 사용자의  메시지는 키보드로 입력도중에 전달되어 화면에 출력된다.
     5. 메시지의 전송은  엔터를 쳤을 때 전송되고  방안의  모든 사용자에게 전달된다.
     6. 방을 나올 때는  “quit” 또는 프로그램 종료로 할 수 있다.
     7. 방을 나가면 다른 사용자에게  “OOO님이 퇴장 하였습니다”  메시지가  출력된다.
< 추가사항 ++ > 
	8. 사용자가 채팅을 입력하면 입력 시간 로그가 전달된다.
	9. 채팅에 접속한 인원을 할 수 있도록한다.
	10. 채팅에 접속한 모든 사용자를 알 수 있도록한다.

서버, 클라이언트 함꼐 만드지 말고, 서버에 프로토콜 구현하면서 프로토콜 테스트는 Xshell(Telnet으로 해볼 것.

Port 는  9999



2. Chatting 서버
서버 기능 정의
	1. 서버는 여러 클라이언트가 접속할 수 있어야 한다. ( 다중 처리 가능, 멀티스레드 프로그래밍)

	2. 서버는 여러 클라이언트에게 동시에 메시지를 보낼 수 있는 브로드캐스팅(broadcasting) 기능이
        있어야 한다.

    3. EchoServer의 각 스레드는  자신의 IO Stream 객체만  사용하면 되었지만 ,  Chat Server에서는 다른 스레드의
        IO Stream을 사용해야 한다. ( printWriter  객체 )

    4. 닉네임을 등록하기 위한 요청,  메시지를 전달하기 위한 요청,  방을 나가기 위한 요청 등  클라이언트의 요청이
        을 구별하기 위해 프로토콜(채팅 프로토콜)을 설계해야 한다.

    5. Encode <-> Decode

          예)
          JOIN:안대혁\r\n
          MESSAGE:방가 ^^;\r\n
          QUIT\r\n


-------------------------MainThread-------------------------


// 1. 서버 소겟 생성
serverSocket = new ServerSocket();

// 2. 바인딩
String hostAddress = InetAddress.getLocalHost().getHostAddress();
serverSocket.bind( new InetSocketAddress( hostAddress, PORT ) );
log( "연결 기다림 " + hostAddress + ":" + PORT );

// 3. 요청 대기
while( true ) {
   Socket socket = serverSocket.accept();
   new ChatServerTread( socket ).start();
}

      -  Main Thread의 주요코드
      -  클라이언트로 부터 연결 요청을 기다린다.
      -  클라이언트와  연결된 후,  클라이언트와 채팅 데이터 통신은 ChatServerTread가  한다.

-------------------------ChatServerThread-------------------------

1. 스레드의  인스턴스 변수
           - 통신을 위한 스트림을 얻어 오기 위해 Socket 객체를 저장해야 한다.
           - 연결된 클라이언트의 닉네임을 저장하고 있어야 한다.


 2. 요청 처리를 위한 Loop 작성
          - run 메소드 오버라이딩
          - main thread로 부터 전달받은 socket를 통해 IO Stream을 받아오는데  문자 단위 처리와  라인 단위
            읽기를 위해  보조 스트림 객체를 생성해서 사용한다.

 3. 프로토콜 분석
         - chat 프로토콜  형식
            요청명령:파라미터1:파라미터2: … \r\n
          -  각 요청을 구분하는 경계가 되는 것은  \r\n 이다.
          - 요청은  “:” 기준으로  요청명령과  파라미터로 분리한다.
          - 각 각의 요청명령을 처리하는  메서드를 구현하고 호출한다.

           3-1. join 프로토콜 구현
                 - 프로토콜
                    “join:nickname\r\n”

                 - 1번째 파라미터 nickname을  thread 객체 변수로 저장한다.

                  -  writer pool에  현재 스레드의  writer 인 printWriter를 저장해야 한다.







public class ChatServerTread extends Thread {

	private String nickname;
	private Socket socket;

	public ChatServerTread( Socket socket ) {
		this.socket = socket;
	}
}


//1. Remote Host Information

//2. 스트림 얻기
bufferedReader =
     new BufferedReader( new InputStreamReader( socket.getInputStream(), StandardCharsets.UTF_8 ) );
printWriter =
     new PrintWriter( new OutputStreamWriter( socket.getOutputStream(), StandardCharsets.UTF_8 ), true );


//3. 요청 처리
while( true ) {
   String request = bufferedReader.readLine();
   if( request == null ) {
      log( "클라이언트로 부터 연결 끊김" );
      break;
   }

   // 4. 프로토콜 분석

}



String[] tokens = request.split( ":" );

if( "join".equals( tokens[0] ) ) {

   doJoin( tokens[1], printWriter );

} else if( "message".equals( tokens[0] ) ) {

   doMessage[ tokens[1] );

} else if( "quit".equals( tokens[0] ) ) {

   doQuit();

} else {

   ChatServer.log( "에러:알수 없는 요청(" + tokes[0] + ")" );
}


private void doJoin( String nickName, Writer writer ) {
   this.nickname = nickName;
   /* writer pool에  저장 */
}




-------------------------  -------------------------
-------------------------  -------------------------
-------------------------  -------------------------

































