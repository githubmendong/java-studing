package thread;

public class ThreadEx01 {
    public static void main(String[] args){
//        for (int i = 0; i< 10; i++){
//            System.out.println(i);
//        }

        new DigitalThread().start();

        for (char c='a'; c<='z'; c++){
            System.out.println(c);
        }
    }
}
