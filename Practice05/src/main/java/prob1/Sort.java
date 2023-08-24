//버블정렬을 적용하는 자바코드를 완성하세요.
//문제에 주어진 배열 [5, 9, 3, 8, 60, 20, 1] 를 내림차순으로 정렬하여
//다음과 같은 출력이 되도록 완성하는 문제입니다.

//<< 출력 결과 >>
//        Before sort.
//        5 9 3 8 60 20 1
//        After Sort.
//        60 20 9 8 5 3 1.

package prob1;

public class Sort {

    public static void main(String[] arg) {

        int array[] = {5, 9, 3, 8, 60, 20, 1};
        int count = array.length;

        System.out.println("Before sort.");

        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }

        // 버블 정렬 알고리즘을 사용하여 내림차순으로 정렬
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (array[j] < array[j + 1]) { // 내림차순 정렬을 위해 '>' 대신 '<' 사용
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // 결과 출력
        System.out.println("\nAfter Sort.");

        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
    }
}