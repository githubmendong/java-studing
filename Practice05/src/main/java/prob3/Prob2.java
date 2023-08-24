//import prob3.Bird;Prob2 클래스를 이용하여 두 클래스의 메소드를 호출시켰을 때,
// 콘솔에 출력되는 결과가 아래와 같도록 클래스 Bird(추상클래스), Duck, Sparrow 를 완성하세요.
//
//		오리(Duck) 클래스와 참새(Sparrow) 클래스는
//		이름을 나타내는 name 데이터를 가지고 있습니다.
//
//		메소드로는
//		Setter/getter 메소드와
//		날다 fly,
//		울다 sing,
//		자신의 이름을 화면에 표시 toString()
//		등을 가지고 있습니다.


package prob3;

public class Prob2 {
    public static void main(String[] args) {
        Bird bird01 = new Duck();
        bird01.setName("꽥꽥이");
        bird01.fly();
        bird01.sing();
        System.out.println(bird01);

        Bird bird02 = new Sparrow();
        bird02.setName("짹짹이");
        bird02.fly();
        bird02.sing();
        System.out.println(bird02);
    }

    public static class Duck extends Bird {
        @Override
        public void fly() {
            System.out.println("오리(" + getName() + ")는 날지 않습니다.");
        }

        @Override
        public void sing() {
            System.out.println("오리(" + getName() + ")가 소리내어 웁니다.");
        }

        @Override
        public String toString() {
            return "오리의 이름은 " + getName() + " 입니다.";
        }
    }

    public static class Sparrow extends Bird {
        @Override
        public void fly() {
            System.out.println("참새(" + getName() + ")가 날아갑니다.");
        }

        @Override
        public void sing() {
            System.out.println("참새(" + getName() + ")가 참새가 노래합니다.");
        }

        @Override
        public String toString() {
            return "참새의 이름은 " + getName() + " 입니다.";
        }
    }
}

