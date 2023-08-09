package chapter03;

public class SwaoTest02 {
	public static void main(String[] args) {
		{
			int a = 10;
			int b = 20;
			
			System.out.println("a : " + a + "b :" + b);
			
			swap(a,b);
			
			System.out.println("a : " + a + "b :" + b);
	}

}

	private static void swap(int m, int n) {
		// TODO Auto-generated method stub
		int temp = m;
		m = n;
		n = temp;
		
	}
}