//   [과제1-1]  NSLookup 구현 하기
//
//   1. Scanner와  nextLine() 메소드를 사용해서  계속 입력받은 도메인을 입력 받는다.
//   2. 입력받은  도메인의 IP 주소를  출력한다.
//   3. “exit” 를 입력 받아  프로그램을 종료할  때 까지 계속  프로그램을 실행한다.
//   4. InetAddress의  static 메서드  getAllByName( String host ) 를 사용한다.
//
//
//
package Practice01;

import java.net.InetAddress;
import java.util.Scanner;

public class localHost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("도메인 입력해주세요. 종료 ,QUIT ");
                String domain = scanner.nextLine();

                if ("exit".equalsIgnoreCase(domain)) {
                    System.out.println("종료.");
                    break;
                }

                InetAddress[] inetAddresses = InetAddress.getAllByName(domain);

                System.out.println("IP addresses for " + domain + ":");
                for (InetAddress inetAddress : inetAddresses) {
                    System.out.println(inetAddress.getHostAddress());
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

