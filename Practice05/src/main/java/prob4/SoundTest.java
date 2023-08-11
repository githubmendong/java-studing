

//    문제 설명 :
//        1. 인터페이스 Soundable를 구현하는 Cat, Dog, Sparrow, Duck 클래스를 작성합니다.
//        2.	SoundTest 클래스에서 printSound 매소드를 구현합니다.
//        3.	실행결과가 동일하게끔 작성되어야 합니다.

//  실행결과
//        “야옹”
//        “멍멍”
//        “짹짹”
//        “꽥꽥”



package prob4;

public class SoundTest {

    public static void main(String[] args) {
        printSound(new Cat());
        printSound(new Dog());
        printSound(new Sparrow());
        printSound(new Duck());
    }

    private static void printSound(Soundable soundable) {
        System.out.println(soundable.sound());
    }
}

