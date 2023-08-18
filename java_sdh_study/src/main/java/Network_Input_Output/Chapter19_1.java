package Network_Input_Output;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Chapter19_1 {
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 ip 주소 : " + local.getHostAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
            for (InetAddress remote : iaArr) {
                System.out.println("www.naver.com:" + remote.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
