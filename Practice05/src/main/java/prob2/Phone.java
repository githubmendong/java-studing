// PhoneApp가 제대로 작동되도록 MusicPhone을 상속한 SmartPhone Class를 작성하세요.
// 실행결과
//
// 다운로드해서 음악재생
// 통화기능시작
// 앱실행


        package prob2;

public class Phone {
	public void execute( String function ) {
		call();
	}

	private void call(){
		System.out.println( "통화기능시작" );
	}
}

