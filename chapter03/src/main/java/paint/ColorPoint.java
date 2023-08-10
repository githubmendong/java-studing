package paint;

public class ColorPoint extends Point {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("점[x="+getX()+".y"+getY()+"]을그렸습니다." );
		super.show();
	}

//	@Override
//	public void m() {
//		
//	}

}
