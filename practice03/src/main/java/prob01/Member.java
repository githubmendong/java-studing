//다음 설명을 읽고 Member 클래스를 작성하세요.
//회원(Member)클래스는 회원 아이디를 나타내는 id(문자열)와
//회원 이름을 나타내는 name(문자열),회원의 point를 나타내는 point(정수)필드를 가지고 있다.
//메소드는 회원의 이름 변경 setName메소드와 이름을 반환하는 getName,
//포인트를 변경하는 setPoint와 포인트를 반환하는 getPoint
//회원아이디를 변경하는 setId,반환하는 getId 메소드를 가지고 있다.
//
//모든 필드는 외부에서 직접 접근하여 값을 변경하거나 얻어가지 못하도록 private로 접근 제한을 막고
//메소드는 제한 없이 모두 호출할 수 있는 접근 제한자를 사용한다.

package prob01;

public class Member {
	private String name; 
	private String id; 
    private int point;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}     
}