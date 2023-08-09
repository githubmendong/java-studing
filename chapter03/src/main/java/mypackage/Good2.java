package mypackage;

public class Good2 {
    public String name;      // 모든 접근이 가능하다 (접근 제한이 없다)
    protected int price;     // 같은 패키지 + 자식 클래스에 접근이 가능
    int countStock;          // 같은 패키지 (디폴트)
    private int countSold;   // 같은 클래스 내에서만 접근이 가능하다.
}