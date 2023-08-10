package prob04;

public class Depart extends Employee {

	private String department;

	public Depart(String name, int salary, String department) {
		// TODO Auto-generated constructor stub
		super(name, salary);
		this.department = department;
	}
	
	@Override
	public void getInformation() {
		super.getInformation();
		System.out.println("부서 : " + department);
	}

}
