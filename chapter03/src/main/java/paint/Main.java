package paint;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);
		
		drawPoint(point1);

	}
	public static void drawPoint(Point point) {
		point.show();
	}

}
