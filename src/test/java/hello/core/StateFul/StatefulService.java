package hello.core.StateFul;

public class StatefulService {
//    private int price;

    public int order(String name, int price) {
        System.out.println("name= "+ name + "Price"+ price);
        return price;
    }
//    스프링빈은 항상 무상태로 설계하자

//    public int getPrice() {
//        return price;
//    }
}
