package chapter03;

public class StudentTest02 {

	public static void main(String[] args) {
		Student s1 = new Student();
		Person p = s1; // 업 캐스팅 (암시적, Implicity)

		Student s2 = (Student) p; // 다운 캐스팅(명시적, Explicity)

	}

}
