package prob2;

public class Prob2 {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = i; j <= i + 9; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
			for (int k = 0; k < i; k++) {
//				System.out.print("\t");
			}
		}
	}
}
