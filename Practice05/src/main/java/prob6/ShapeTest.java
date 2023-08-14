//그림과 같은 상속관계를 나타내고 있을 때, 아래 질문에 대한 클래스를 작성하십시오.
//<< 출력 결과 >>
//
//        area: 30.0
//        perimeter: 22.0
//        new area: 7.5
//        new perimeter: 11.0
//        area: 6.0
//        perimeter: 14.32455532033676
//        .
//문제 힌트 및 제한 사항 :
//        1.	별도로 제시되는 소스 파일이 없습니다.
//
//        2.	이번 문제에서 작성해야 할 소스 파일은 총 5개입니다.
//        Shape.java,
//        Resizable.java,
//        Rectangle.java,
//        RectTriangle.java,
//        ShapeTest.java (주어짐)
//
//        3.	적용해야 할 식
//        1.	Perimeter(둘레)
//        RectTriangle(직각삼각형) : width + height +
//        Rectangle(사각형) : ( width + height ) x 2
//
//        2.	Area(넓이)
//        RectTriangle(직각삼각형) : width x height x
//        Rectangle(사각형) : width x height
//
//
//
//


package prob6;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<Shape>();

		list.add( new Rectangle(5, 6) );
		list.add( new RectTriangle( 6, 2) );

		for( Shape shape : list ) {
			System.out.println( "area:" + shape.getArea() );
			System.out.println( "perimeter:" + shape.getPerimeter() );

			if( shape instanceof Resizable ) {
				Resizable resizable = (Resizable) shape;
				resizable.resize( 0.5 );
				System.out.println( "new area:" + shape.getArea() );
				System.out.println( "new perimeter:" + shape.getPerimeter() );
			}
		}
	}
}