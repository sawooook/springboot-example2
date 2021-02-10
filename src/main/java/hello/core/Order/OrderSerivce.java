package hello.core.Order;

public interface OrderSerivce {
    Order createOrder(Long MemberId, String itemName, int itemPice);
}
