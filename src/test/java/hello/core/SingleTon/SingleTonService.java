package hello.core.SingleTon;

public class SingleTonService {

/*
* 싱글톤 패턴을 구현하는 코드 자체가 많이 들어감
* DIP를 위반함 -> 구체클래스에 의존하게됨
* OCP -> 구체 클래스에 의존하므로 폐쇄적이지 않게 됨
* private생성자 쓰면 자식 클래스 만들기 어려움
* 유연성이 떨어짐
* 안티패턴이라고 불림
* */

    private static final SingleTonService instance = new SingleTonService();
    // static 영역에 하나만 올라간다.

    public static SingleTonService getInstance() {
        return instance;
    }

    // 딱 1개만 존재하므로 new 키워드로 객체 인스턴스가 생성 되는걸 막아야함
    private SingleTonService() {
    }

    private void logic() {
        System.out.println("싱글톤 객체 로직 생성");
    }
}
