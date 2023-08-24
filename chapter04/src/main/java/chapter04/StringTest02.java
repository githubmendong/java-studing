package chapter04;

public class StringTest02 {
    public static void main(String[] args){
        //뷸변성 (immutability)

        String s1 = "abc";
        String s2 = "def";
        String s3 = s2;

        s2 = s1.toUpperCase();
        String s4 = s2.concat("??");
        String s5 = "!".concat(s2).concat("@"); //
        //s1 -> abc 참조
        // s2,s3 -> def 참조
        // 새로운 호출을 당하면 내부는 초기화 된다.
        // s4는 "ABC??" 출력
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
//        System.out.println(equalsHello("hello"));
    }

    private static boolean equalsHello(String s){
//        return s.equals("Hello"); // -> 이렇게 짜면 비추
        return "Hello".equals(s);
    }
}
