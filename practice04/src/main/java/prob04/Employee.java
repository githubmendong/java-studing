//[문제4]
//다음은 Employee클래스를 상속받아 Depart클래스를 구현합니다.
//Depart클래스를 구현할 때 실행결과를 참조합니다.
//
//<<실행결과>>
//이름: 홍길동   연봉: 3000   부서:기획부
//
//<<주의사항>>
//1	Employee.java 와 Prob04.java클래스는 수정하지 않습니다.
//2	Depart클래스에 멤버변수를 String department변수외에 추가하지 않습니다.



package prob04;

public class Employee {
	private String name;
	private int salary;

	public Employee() {
	}

	Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void getInformation() {
		System.out.println( "이름:" + name + "연봉:" + salary );
	}
}
