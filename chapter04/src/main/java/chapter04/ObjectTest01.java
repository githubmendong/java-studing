package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();

//		Class klass = point.getClass();
		System.out.println(point.getClass());
		System.out.println(point.hashCode()); 	//address X
												// reference x
												// address 기반의 해싱값 o

		System.out.println(point.toString()); 	//getClass() + "@" + hashCode()
		System.out.println(point);
	}

}
