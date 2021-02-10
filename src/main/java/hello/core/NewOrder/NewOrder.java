package hello.core.NewOrder;

public class NewOrder {
    String name;
    int price;
    Long memberId;

    public NewOrder(String name, int price, Long memberId) {
        this.name = name;
        this.price = price;
        this.memberId = memberId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "NewOrder{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", memberId=" + memberId +
                '}';
    }
}
