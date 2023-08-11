package chapter04;

public class ObjectTest03 {
    public static void main(String[] args){
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        //데이터가 힙에 저장되나 서로 다른 값을 가리킴

        System.out.println(s1 == s2); //False
        System.out.println(s1.equals(s2)); //true
        System.out.println(s1.hashCode() + " : " + s2.hashCode());
        System.out.println("s1:"+System.identityHashCode(s1)); //주소 값에 해쉬코드를 뽑을 수 있는 유틸리티
        System.out.println("s2:"+System.identityHashCode(s2)); //주소 값에 해쉬코드를 뽑을 수 있는 유틸리티

        // 스트림은 오버라이딩되어 힙에 저장되어 다른 값으로 자리를 잡는다.
        //아래는 같은 객체를 가리키고 있다.
        System.out.println(("======================================="));

        String s3= "hello";
        String s4= "hello";

        System.out.println(s3 == s4); //False
        System.out.println(s3.equals(s4)); //true
        System.out.println(s3.hashCode() + " : " + s4.hashCode());
        System.out.println("s1:"+System.identityHashCode(s3)); //주소 값에 해쉬코드를 뽑을 수 있는 유틸리티
        System.out.println("s2:"+System.identityHashCode(s4)); //주소 값에 해쉬코드를 뽑을 수 있는 유틸리티

    }
}
