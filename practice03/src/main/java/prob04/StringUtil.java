package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder();
		
		//배열의 모든 문자열을 순회
		for (String str : strArr) {
			result.append(str);
		}
		return result.toString();
	}
}
