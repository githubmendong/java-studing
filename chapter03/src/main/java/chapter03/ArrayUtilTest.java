package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		int[] a = { 10, 20, 30, 40 };

		double[] d = ArrayUtil.intToDouble(a);
		System.out.println(Arrays.toString(d));

		int[] a1 = ArrayUtil.doubleToInt(new double[] { 10.0, 20.0, 30.0, 40.0 });
		System.out.println(Arrays.toString(a1));

		int[] a2 = ArrayUtil.concat(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 });
		System.out.println(a2);
	}

}