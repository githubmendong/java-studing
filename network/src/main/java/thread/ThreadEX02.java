package thread;

public class ThreadEX02 {
    public static void main(String[] args){
        Thread thread01 = new DigitalThread();
        Thread thread02 = new AlphabetThead();

        thread01.start();
        thread02.start();
    }
}
